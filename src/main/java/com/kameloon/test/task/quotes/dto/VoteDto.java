package com.kameloon.test.task.quotes.dto;

import com.kameloon.test.task.quotes.models.Vote;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link Vote} entity
 */
@Data
public class VoteDto implements Serializable {
    private final Long quoteId;
    private final Long userId;
    private final LocalDateTime dateTime;
}