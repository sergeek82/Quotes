package com.kameloon.test.task.quotes.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "votes_audit")
@NoArgsConstructor
@Setter
@Getter
public class VoteAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long voteId;
    private String operation;
    private LocalDateTime timestamp;
    private Long quoteId;
}
