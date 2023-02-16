package com.kameloon.test.task.quotes.service.impl;

import com.kameloon.test.task.quotes.dto.UserDto;
import com.kameloon.test.task.quotes.mapper.UserMapper;
import com.kameloon.test.task.quotes.models.User;
import com.kameloon.test.task.quotes.repository.UserRepository;
import com.kameloon.test.task.quotes.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper mapper;
    private final UserRepository repository;

    @Override
    public UserDto addUser(UserDto userDto) {
        boolean notExist = repository.findFirstByEmail(userDto.getLogin()).isEmpty();
        if (notExist) {
            User user = mapper.toEntity(userDto);
            return mapper.toDto(repository.save(user));
        }
        throw new IllegalArgumentException("This email is already in use.");
    }
}
