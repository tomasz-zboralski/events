package com.crud.events.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private Long eventId;
    @Enumerated(EnumType.STRING)
    private EventType eventType;
    private LocalDateTime startTime;
    private String place;
    @Length(max = 50)
    private String name;
    private String description;
    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "JOIN_EVENT_USER",
            joinColumns = {@JoinColumn(name = "EVENT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "USER_ID")}
    )
    private Set<User> users = new HashSet<>();

    public Event(Long eventId, String name, String description) {
        this.eventId = eventId;
        this.name = name;
        this.description = description;
    }
}
