package com.kameloon.test.task.quotes.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "votes")
@NoArgsConstructor
@Setter
@Getter
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateTime;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quote_id")
    private Quote quote;
    @OneToMany(mappedBy = "voteId")
    List<VoteAudit> voteAudits;
}
