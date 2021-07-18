package com.crud.events.service;

import com.crud.events.domain.Event;
import com.crud.events.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public Set<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> findEvent(final Long id) {
        return eventRepository.findById(id);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(final Long id) {
        eventRepository.deleteById(id);
    }
}
