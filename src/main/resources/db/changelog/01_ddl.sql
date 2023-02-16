-- liquibase formatted sql

-- changeSet Filimonov:1 endDelimiter:go

CREATE TABLE IF NOT EXISTS users
(
    id               BIGSERIAL PRIMARY KEY,
    email            VARCHAR(255)
        CONSTRAINT uk_6dotkott2kjsp8vw4d0m25fb7
            UNIQUE,
    last_change_date TIMESTAMP,
    name             VARCHAR(255),
    password         VARCHAR(255)
        CONSTRAINT uk_r53o2ojjw4fikudfnsuuga336
            UNIQUE
);

CREATE TABLE IF NOT EXISTS quotes
(
    id        BIGSERIAL PRIMARY KEY,
    content   VARCHAR(255),
    date_time TIMESTAMP,
    user_id   BIGINT
        CONSTRAINT fkbwr7u11tqw8jekeijdbngy3ku
            REFERENCES users
);

CREATE TABLE IF NOT EXISTS votes
(
    id        BIGSERIAL PRIMARY KEY,
    date_time TIMESTAMP,
    quote_id  BIGINT
        CONSTRAINT fkexfdocr76wt0d3pi8i5f44ke
            REFERENCES quotes,
    user_id   BIGINT
        CONSTRAINT fkli4uj3ic2vypf5pialchj925e
            REFERENCES users
);

CREATE TYPE VOTE_TYPE AS ENUM ('UP_VOTE','DOWN_VOTE');

CREATE TABLE IF NOT EXISTS votes_audit
(
    id        BIGSERIAL PRIMARY KEY,
    vote_id   BIGINT    NOT NULL,
    operation VOTE_TYPE NOT NULL,
    timestamp TIMESTAMP NOT NULL UNIQUE,
    quote_id  BIGINT    NOT NULL

);

CREATE OR REPLACE FUNCTION votes_audit_func() RETURNS TRIGGER
AS
$BODY$
BEGIN
    IF (tg_op = 'INSERT') THEN
        INSERT INTO votes_audit(vote_id, operation, timestamp, quote_id)
        VALUES (new.id, 'UP_VOTE', CURRENT_TIMESTAMP, new.quote_id);
        RETURN new;
    ELSEIF (tg_op = 'DELETE') THEN
        INSERT INTO votes_audit(vote_id, operation, timestamp, quote_id)
        VALUES (old.id, 'DOWN_VOTE', CURRENT_TIMESTAMP, old.quote_id);
        RETURN old;
    END IF;
END;
$BODY$
    LANGUAGE plpgsql;

CREATE TRIGGER vote_trigger
    AFTER INSERT OR DELETE
    ON votes
    FOR EACH ROW
EXECUTE FUNCTION votes_audit_func();
