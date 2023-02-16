package com.kameloon.test.task.quotes.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.kameloon.test.task.quotes.models.VoteAudit} entity
 */
@Data
public class VoteAuditDto implements Serializable {
    private final Long id;
    private final Long voteId;
    private final String operation;
    private final LocalDateTime timestamp;
    private final Long quoteId;
}