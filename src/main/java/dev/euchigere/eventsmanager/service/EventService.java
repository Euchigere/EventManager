package dev.euchigere.eventsmanager.service;

import dev.euchigere.eventsmanager.dto.ServiceResponse;
import dev.euchigere.eventsmanager.models.Event;

import java.util.List;

public interface EventService {
    ServiceResponse<List<Event>> getAllEvents();
}
