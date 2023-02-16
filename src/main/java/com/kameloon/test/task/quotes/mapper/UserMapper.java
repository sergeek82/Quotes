package com.kameloon.test.task.quotes.mapper;

import com.kameloon.test.task.quotes.dto.UserDto;
import com.kameloon.test.task.quotes.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "login", source = "email")
    UserDto toDto(User user);

    @Mapping(target = "votes", ignore = true)
    @Mapping(target = "email", source = "login")
    @Mapping(target = "quotes", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "lastChangeDate", expression = "java(java.time.LocalDateTime.now())")
    User toEntity(UserDto userDto);
}
