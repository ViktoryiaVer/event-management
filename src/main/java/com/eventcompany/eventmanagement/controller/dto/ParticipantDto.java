package com.eventcompany.eventmanagement.controller.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ParticipantDto {
    String firstName;
    String lastName;
    String email;
}
