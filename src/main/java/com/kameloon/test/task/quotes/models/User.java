package com.kameloon.test.task.quotes.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime lastChangeDate;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Quote> quotes;
    @OneToMany(mappedBy = "user")
    private List<Vote> votes;
}
