package com.crud.events.repository;

import com.crud.events.domain.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

    @Override
    Set<Event> findAll();
}
