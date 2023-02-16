package com.kameloon.test.task.quotes.repository;

import com.kameloon.test.task.quotes.models.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

    Optional<Quote> findFirstByContent(String content);

    List<Quote> findTop10ByVotesNotNullOrderByVotesAsc();

    List<Quote> findTop10ByVotesNotNullOrderByVotesDesc();
}
