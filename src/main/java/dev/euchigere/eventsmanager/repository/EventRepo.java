package dev.euchigere.eventsmanager.repository;

import dev.euchigere.eventsmanager.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event, Long> {
}
