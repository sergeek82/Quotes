package com.kameloon.test.task.quotes.service.impl;

import com.kameloon.test.task.quotes.dto.QuoteDto;
import com.kameloon.test.task.quotes.mapper.QuoteMapper;
import com.kameloon.test.task.quotes.models.Quote;
import com.kameloon.test.task.quotes.repository.QuoteRepository;
import com.kameloon.test.task.quotes.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {
    private final QuoteRepository repository;
    private final QuoteMapper mapper;
    public static final String NOT_FOUND = "Quote not found with id :: ";

    @Override
    public QuoteDto addQuote(QuoteDto quoteDto) {
        boolean notExist = repository.findFirstByContent(quoteDto.getContent()).isEmpty();
        if (notExist) {
            Quote quote = mapper.toEntity(quoteDto);
            return mapper.toDto(repository.save(quote));
        }
        throw new IllegalArgumentException("The content already exist.");
    }

    @Override
    public QuoteDto getQuote(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND.concat(id.toString()))));
    }

    @Override
    public List<QuoteDto> getTopAsc() {
        return mapper.toListDto(repository.findTop10ByVotesNotNullOrderByVotesAsc());
    }

    @Override
    public List<QuoteDto> getTopDec() {
        return mapper.toListDto(repository.findTop10ByVotesNotNullOrderByVotesDesc());
    }

    @Override
    public QuoteDto updateQuote(QuoteDto quoteDto, Long id) {
        Quote quote =
                repository.findById(id).orElseThrow(() -> new EntityNotFoundException(NOT_FOUND.concat(id.toString())));
        quote.setContent(quoteDto.getContent());
        return mapper.toDto(repository.save(quote));
    }

    @Override
    public QuoteDto removeQuote(Long id) {
        Quote quote =
                repository.findById(id).orElseThrow(() -> new EntityNotFoundException(NOT_FOUND.concat(id.toString())));
        repository.delete(quote);
        return mapper.toDto(quote);
    }
}
