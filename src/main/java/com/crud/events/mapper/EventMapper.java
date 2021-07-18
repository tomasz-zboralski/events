package com.crud.events.mapper;

import com.crud.events.domain.Event;
import com.crud.events.domain.EventDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
@Service
public interface EventMapper {
    Event mapToEvent(EventDto eventDto);
    EventDto mapToEventDto(Event event);
}
