package com.crud.events.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
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
    @Length(max = 50)
    private String name;
    @Email
    private String email;

    @JsonBackReference
    @ManyToMany(mappedBy = "users")
    private Set<Event> events = new HashSet<>();

    public User(Long userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}
