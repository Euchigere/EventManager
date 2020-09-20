package dev.euchigere.eventsmanager.service;

import dev.euchigere.eventsmanager.dto.ServiceResponse;
import dev.euchigere.eventsmanager.models.Event;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface EventService {
    ServiceResponse<List<Event>> getAllEvents();

    void addEvent(Event event);

    ServiceResponse<Event> getEventFromSession(HttpSession session, int index);

    void deleteEvent(Event event);
}
