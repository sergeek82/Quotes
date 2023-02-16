package com.kameloon.test.task.quotes.mapper;

import com.kameloon.test.task.quotes.dto.VoteDto;
import com.kameloon.test.task.quotes.models.Vote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VoteMapper {

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "quoteId", source = "quote.id")
    VoteDto toDto(Vote vote);
}
