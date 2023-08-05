package com.eventcompany.eventmanagement.service;

import com.eventcompany.eventmanagement.exception.ObjectNotFoundException;
import com.eventcompany.eventmanagement.model.entity.Event;
import com.eventcompany.eventmanagement.model.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository repository;

    @Override
    public List<Event> getAll() {
        return repository.findAll();
    }

    @Override
    public Event getById(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Object not found"));
    }

    @Override
    public Event save(Event event) {
        return repository.save(event);
    }

    @Override
    public Event update(Event event) {
        return repository.save(event);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
