package dev.euchigere.eventsmanager.dto;

import dev.euchigere.eventsmanager.models.Department;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Handler;

@Data
@NoArgsConstructor
@Component
public class EventDTO {
    private Long id;
    private String title;
    private String description;
    private String venue;
    private LocalDate date;
    private LocalTime time;
    private String attendanceType;
    private Long noOfAttendees;

    private Set<Department> departments = new HashSet<>();
}
