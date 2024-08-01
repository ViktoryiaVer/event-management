package com.eventcompany.eventmanagement.service;

import com.eventcompany.eventmanagement.model.entity.Event;
import com.eventcompany.eventmanagement.model.entity.Participant;

import java.util.List;

public interface EventService {
    List<Event> getAll();

    Event getById(String id);

    Event save(Event event);

    Event update(Event event);

    void deleteById(String id);

    Event addParticipant(String eventId, Participant participant);
}
