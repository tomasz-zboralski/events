package com.crud.events.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long user_id;
    private Long name;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Set<Event> events = new HashSet<>();

}
