package com.crud.events.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EventType {
    MUSIC("Music"),
    SPORT("Sport"),
    EDUCATION("Education");
    private String type;
}
