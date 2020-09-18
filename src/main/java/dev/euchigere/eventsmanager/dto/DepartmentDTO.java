package dev.euchigere.eventsmanager.dto;

import dev.euchigere.eventsmanager.models.Event;
import dev.euchigere.eventsmanager.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Component
public class DepartmentDTO {
    private Long id;
    private String name;

    private List<User> users;
    private Set<Event> events = new HashSet<>();

    public void setName(String name) {
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}
