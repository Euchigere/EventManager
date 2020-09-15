package dev.euchigere.eventsmanager.dto;

import dev.euchigere.eventsmanager.models.Event;
import dev.euchigere.eventsmanager.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Data
@NoArgsConstructor
@Component
public class DepartmentDTO {
    private Long id;
    private String name;

    private List<User> users;
    private List<Event> events;
}
