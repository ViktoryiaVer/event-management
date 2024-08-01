package com.eventcompany.eventmanagement.mapper;

import com.eventcompany.eventmanagement.controller.dto.ParticipantDto;
import com.eventcompany.eventmanagement.model.entity.Participant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ParticipantMapper {
    ParticipantDto toDto(Participant participant);

    Participant toEntity(ParticipantDto participantDto);
}
