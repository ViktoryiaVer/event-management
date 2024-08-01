package com.eventcompany.eventmanagement.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class EventDto {
    String id;
    String name;
    String description;
    String theme;
    Integer durationInMinutes;
    @Builder.Default
    List<ParticipantDto> participants = new ArrayList<>();
}
