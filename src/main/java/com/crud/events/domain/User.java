package com.crud.events.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of = {"userId", "name" })
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;
    private String name;

    @ManyToMany(mappedBy = "users")
    private Set<Event> events = new HashSet<>();

    public User(Long userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}
