package com.eventcompany.eventmanagement.controller;

import com.eventcompany.eventmanagement.controller.dto.EventDto;
import com.eventcompany.eventmanagement.controller.dto.ParticipantDto;
import com.eventcompany.eventmanagement.mapper.EventMapper;
import com.eventcompany.eventmanagement.mapper.ParticipantMapper;
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
    private final EventMapper eventMapper;
    private final ParticipantMapper participantMapper;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public List<EventDto> getAllEvents() {
        return eventService.getAll().stream().map(eventMapper::toDto).toList();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public EventDto getEventById(@PathVariable String id) {
        return eventMapper.toDto(eventService.getById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public EventDto saveEvent(@RequestBody EventDto event) {
        return eventMapper.toDto(eventService.save(eventMapper.toEntity(event)));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public EventDto updateEvent(@PathVariable String id, @RequestBody EventDto event) {
        event.setId(id);
        return eventMapper.toDto(eventService.update(eventMapper.toEntity(event)));
    }

    @PutMapping("/{id}/participants")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public EventDto addParticipantToEvent(@PathVariable String id, @RequestBody ParticipantDto participant) {
        return eventMapper.toDto(eventService.addParticipant(id, participantMapper.toEntity(participant)));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEvent(@PathVariable String id) {
        eventService.deleteById(id);
    }
}
