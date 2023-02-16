package com.kameloon.test.task.quotes.service.impl;

import com.kameloon.test.task.quotes.dto.VoteAuditDto;
import com.kameloon.test.task.quotes.dto.VoteDto;
import com.kameloon.test.task.quotes.mapper.VoteAuditMapper;
import com.kameloon.test.task.quotes.mapper.VoteMapper;
import com.kameloon.test.task.quotes.models.Quote;
import com.kameloon.test.task.quotes.models.Vote;
import com.kameloon.test.task.quotes.repository.QuoteRepository;
import com.kameloon.test.task.quotes.repository.VoteAuditRepository;
import com.kameloon.test.task.quotes.repository.VoteRepository;
import com.kameloon.test.task.quotes.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

import static com.kameloon.test.task.quotes.service.impl.QuoteServiceImpl.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService {

    private final VoteRepository repository;
    private final QuoteRepository quoteRepository;
    private final VoteMapper mapper;
    private final VoteAuditRepository voteAuditRepository;
    private final VoteAuditMapper voteAuditMapper;

    @Override
    public VoteDto upVote(Long quoteId) {
        Quote quote = quoteRepository.findById(quoteId)
                .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND.concat(quoteId.toString())));
        Vote vote = new Vote();
        vote.setUser(quote.getUser());
        vote.setQuote(quote);
        vote.setDateTime(LocalDateTime.now());
        return mapper.toDto(repository.save(vote));
    }

    @Override
    public VoteDto downVote(Long quoteId) {
        Quote quote = quoteRepository.findById(quoteId)
                .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND.concat(quoteId.toString())));
        Vote vote = repository.findFirstByQuote(quote)
                .orElseThrow(() -> new EntityNotFoundException("No more votes on quote with id :: ".concat(quoteId.toString())));
        repository.delete(vote);
        return mapper.toDto(vote);
    }

    @Override
    public List<VoteAuditDto> getActivityById(Long quoteId) {
        Quote quote = quoteRepository.findById(quoteId)
                .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND.concat(quoteId.toString())));
        List<VoteAuditDto> voteAuditDtos =
                voteAuditMapper.toListDto(voteAuditRepository.findTop20ByQuoteId(quote.getId()));
        return voteAuditDtos;
    }
}
