package com.kameloon.test.task.quotes.repository;

import com.kameloon.test.task.quotes.models.Quote;
import com.kameloon.test.task.quotes.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findFirstByQuote(Quote quote);
}
