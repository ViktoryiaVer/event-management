package com.eventcompany.eventmanagement.service;

import com.eventcompany.eventmanagement.model.entity.Event;

import java.util.List;

public interface EventService {
    List<Event> getAll();

    Event getById(String id);

    Event save(Event event);

    Event update(Event event);

    void deleteById(String id);
}
