package com.eventcompany.eventmanagement.model.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Data
@Document("events")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Event {
    @Id
    private String id;
    private String name;
    private String description;
    private String theme;
    @Field("duration_in_minutes")
    private Integer durationInMinutes;
    private List<Participant> participants = new ArrayList<>();
}
