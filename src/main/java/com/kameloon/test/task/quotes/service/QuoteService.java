package com.kameloon.test.task.quotes.service;

import com.kameloon.test.task.quotes.dto.QuoteDto;

import java.util.List;

public interface QuoteService {
    QuoteDto addQuote(QuoteDto quoteDto);

    QuoteDto getQuote(Long id);

    List<QuoteDto> getTopAsc();

    List<QuoteDto> getTopDec();

    QuoteDto updateQuote(QuoteDto quoteDto, Long id);

    QuoteDto removeQuote(Long id);
}
