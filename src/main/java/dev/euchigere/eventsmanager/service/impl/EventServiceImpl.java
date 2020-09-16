package dev.euchigere.eventsmanager.service.impl;

import dev.euchigere.eventsmanager.dto.ServiceResponse;
import dev.euchigere.eventsmanager.models.Event;
import dev.euchigere.eventsmanager.repository.EventRepo;
import dev.euchigere.eventsmanager.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventRepo eventRepo;

    public ServiceResponse<List<Event>> getAllEvents() {
        ServiceResponse<List<Event>> response = new ServiceResponse<>();
        response.setData(eventRepo.findAll());
        return response;
    }
}
