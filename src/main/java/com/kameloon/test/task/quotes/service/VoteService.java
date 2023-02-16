package com.kameloon.test.task.quotes.service;

import com.kameloon.test.task.quotes.dto.VoteAuditDto;
import com.kameloon.test.task.quotes.dto.VoteDto;

import java.util.List;

public interface VoteService {
    VoteDto upVote(Long quoteId);

    VoteDto downVote(Long quoteId);

    List<VoteAuditDto> getActivityById(Long quoteId);
}
