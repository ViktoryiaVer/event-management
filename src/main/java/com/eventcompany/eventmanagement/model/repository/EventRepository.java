package com.eventcompany.eventmanagement.model.repository;

import com.eventcompany.eventmanagement.model.entity.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, String> {
}
