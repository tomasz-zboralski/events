package com.crud.events.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "EVENTS")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EVENT_ID")
    private Long event_id;
    private String name;
    private String description;
    @ManyToMany
    @JoinTable(
            name = "JOIN_EVENT_USER",
            joinColumns = {@JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")}
    )
    private Set<User> users = new HashSet<>();

}
