package com.kameloon.test.task.quotes.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link com.kameloon.test.task.quotes.models.User} entity
 */
@Data
public class UserDto implements Serializable {
    @NotNull
    @NotBlank
    private final String name;
    @Email
    @NotNull
    @NotBlank
    private final String login;
    @NotNull
    @NotBlank
    @Length(min = 6, max = 12)
    private final String password;
}