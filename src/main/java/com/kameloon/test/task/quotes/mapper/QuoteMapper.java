package com.kameloon.test.task.quotes.mapper;

import com.kameloon.test.task.quotes.dto.QuoteDto;
import com.kameloon.test.task.quotes.models.Quote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuoteMapper {

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "dateTime", defaultExpression = "java(LocalDateTime.now())")
    QuoteDto toDto(Quote quote);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "votes", ignore = true)
    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "id", ignore = true)
    Quote toEntity(QuoteDto quoteDto);

    List<QuoteDto> toListDto(List<Quote> quoteList);
}
