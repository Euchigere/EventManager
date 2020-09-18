package dev.euchigere.eventsmanager.repository;

import dev.euchigere.eventsmanager.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepo extends JpaRepository<Event, Long> {
    Optional<Event> findEventById(Long eventId);

}
