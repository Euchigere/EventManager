package dev.euchigere.eventsmanager.dto;

import dev.euchigere.eventsmanager.models.Department;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Component
public class EventDto {
    private Long id;
    private String title;
    private String description;
    private String venue;
    private LocalDate date;
    private LocalTime time;
    private String attendanceType;
    private Long noOfAttendees;

    private String message;
    private boolean status;

    private List<Department> departments;
}
