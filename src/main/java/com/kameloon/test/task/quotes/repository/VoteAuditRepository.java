package com.kameloon.test.task.quotes.repository;

import com.kameloon.test.task.quotes.models.VoteAudit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoteAuditRepository extends JpaRepository<VoteAudit, Long> {

    List<VoteAudit> findTop20ByQuoteId(Long quoteId);
}
