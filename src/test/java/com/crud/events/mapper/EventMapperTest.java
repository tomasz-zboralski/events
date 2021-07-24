package com.crud.events.mapper;

import com.crud.events.domain.Event;
import com.crud.events.domain.EventDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EventMapperTest {

    @Autowired
    EventMapper eventMapper;

    @Test
    void mapToEventTest() {

        //given
        EventDto eventDto = new EventDto();
        eventDto.setEventId(1L);
        eventDto.setName("Test");
        eventDto.setDescription("Test Description");

        //when
        Event event = eventMapper.mapToEvent(eventDto);

        //then
        assertThat(event).isNotNull();
        assertThat(event.getEventId()).isEqualTo(1L);
        assertThat(event.getName()).isEqualTo("Test");
        assertThat(event.getDescription()).isEqualTo("Test Description");
    }

    @Test
    void mapToEventDtoTest() {

        //given
        Event event = new Event(1L, "Test", "Test Description");

        //when
        EventDto eventDto = eventMapper.mapToEventDto(event);

        //then
        assertThat(eventDto).isNotNull();
        assertThat(eventDto.getEventId()).isEqualTo(1L);
        assertThat(eventDto.getName()).isEqualTo("Test");
        assertThat(eventDto.getDescription()).isEqualTo("Test Description");

    }
}