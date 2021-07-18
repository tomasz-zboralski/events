package com.crud.events.controller;

import com.crud.events.domain.Event;
import com.crud.events.domain.EventDto;
import com.crud.events.exception.EventNotFoundException;
import com.crud.events.mapper.EventMapper;
import com.crud.events.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/events")
public class EventController {

    private final EventService eventService;
    private final EventMapper eventMapper;

    @GetMapping()
    public Set<EventDto> getAllEvents() {
        return eventMapper.mapToEventDtoSet(eventService.getAllEvents());
    }

    @GetMapping(value = "/{eventId}")
    public EventDto getEvent(@PathVariable Long eventId) {
        return eventMapper.mapToEventDto(eventService.findEvent(eventId).orElseThrow(EventNotFoundException::new));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public EventDto createEvent(@RequestBody EventDto eventDto) {
        Event event = eventMapper.mapToEvent(eventDto);
        return eventMapper.mapToEventDto(eventService.createEvent(event));
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public EventDto updateEvent(@RequestBody EventDto eventDto) {
        Event event = eventMapper.mapToEvent(eventDto);
        return eventMapper.mapToEventDto(eventService.createEvent(event));
    }

    @DeleteMapping(value = "/{eventId}")
    public void deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
    }
}