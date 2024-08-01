package com.eventcompany.eventmanagement.mapper;

import com.eventcompany.eventmanagement.controller.dto.EventDto;
import com.eventcompany.eventmanagement.model.entity.Event;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = ParticipantMapper.class)
public interface EventMapper {
    EventDto toDto(Event event);

    Event toEntity(EventDto eventDto);
}
