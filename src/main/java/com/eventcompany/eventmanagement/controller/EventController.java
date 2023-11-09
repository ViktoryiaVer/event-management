package com.eventcompany.eventmanagement.controller;

import com.eventcompany.eventmanagement.exception.ObjectNotFoundException;
import com.eventcompany.eventmanagement.model.entity.Event;
import com.eventcompany.eventmanagement.model.entity.Participant;
import com.eventcompany.eventmanagement.model.repository.EventRepository;
import com.eventcompany.eventmanagement.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;
    private final EventRepository eventRepository;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public List<Event> getAllEvents() {
        return eventService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public Event getEventById(@PathVariable String id) {
        return eventService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Event saveEvent(@RequestBody Event event) {
        return eventService.save(event);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Event updateEvent(@PathVariable String id, @RequestBody Event event) {
        event.setId(id);
        return eventService.update(event);
    }

    @PutMapping("/{id}/participants")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Event addParticipantToEvent(@PathVariable String id, @RequestBody Participant participant) {
        Event eventToUpdate = eventRepository.findById(id).orElseThrow( () -> new ObjectNotFoundException("Event not found"));
        eventToUpdate.getParticipants().add(participant);
        return eventService.update(eventToUpdate);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEvent(@PathVariable String id) {
        eventService.deleteById(id);
    }
}
