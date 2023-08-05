package com.eventcompany.eventmanagement.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
public class Participant {
    @Field("first_name")
    private String firstName;
    @Field("last_name")
    private String lastName;
    private String email;
}
