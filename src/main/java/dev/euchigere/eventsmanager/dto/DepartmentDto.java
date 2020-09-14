package dev.euchigere.eventsmanager.dto;

import dev.euchigere.eventsmanager.models.Event;
import dev.euchigere.eventsmanager.models.User;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.List;

@Data
@Component
public class DepartmentDto {
    private Long id;
    private String name;

    private String message;
    private boolean status;

    private List<User> users;
    private List<Event> events;
}
