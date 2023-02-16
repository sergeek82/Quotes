package com.kameloon.test.task.quotes.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.kameloon.test.task.quotes.models.Quote} entity
 */
@Data
public class QuoteDto implements Serializable {
    @NotNull
    @NotBlank
    private final String content;
    private final LocalDateTime dateTime;
    @NotNull
    private final Long userId;
}