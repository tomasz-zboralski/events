package com.crud.events.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    private Long eventId;
    private String name;
    private String description;
    private Set<UserDto> users = new HashSet<>();
}
