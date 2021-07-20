package com.crud.events.service;

import com.crud.events.domain.Event;
import com.crud.events.domain.User;
import com.crud.events.exception.EventNotFoundException;
import com.crud.events.exception.UserNotFoundException;
import com.crud.events.repository.EventRepository;
import com.crud.events.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

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

    @Transactional
    public Set<User> addParticipant(Long eventId, Long userId) {
        Event event = eventRepository.findById(eventId).orElseThrow(EventNotFoundException::new);
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);

        event.getUsers().add(user);
        eventRepository.save(event);

        return event.getUsers();
    }

    @Transactional
    public void removeParticipant(Long eventId, Long userId) {
        Event event = eventRepository.findById(eventId).orElseThrow(EventNotFoundException::new);
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        Set<User> participants = event.getUsers();

        if (participants.contains(user)) {
            participants.remove(user);
            eventRepository.save(event);
        }
    }
}
