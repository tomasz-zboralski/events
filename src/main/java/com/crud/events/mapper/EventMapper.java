package com.crud.events.mapper;

import com.crud.events.domain.Event;
import com.crud.events.domain.EventDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

import java.util.Set;

@Mapper(componentModel = "spring", uses = UserMapper.class)
@Service
public interface EventMapper {
    Event mapToEvent(EventDto eventDto);
    @Mapping(target = "users", source = "users")
    EventDto mapToEventDto(Event event);
    Set<Event> mapToEventSet(Set<EventDto> eventDtoSet);
    Set<EventDto> mapToEventDtoSet(Set<Event> eventSet);
}
