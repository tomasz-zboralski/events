package com.crud.events.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    private Long event_id;
    private String name;
    private String description;
    private Set<User> users;
}
