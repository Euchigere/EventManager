package dev.euchigere.eventsmanager.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String venue;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private LocalTime time;
    private String attendanceType;
    private Long noOfAttendees = 0l;

    @ManyToMany
    private Set<Department> departments = new HashSet<>();

    @Transient
    private List<Long> deptIds;

    public void setTime(String time) {
        this.time = LocalTime.parse(time);
    }

    //Getters and setters
    public void addDepartment(Department dept) {
        departments.add(dept);
        dept.getEvents().add(this);
    }

    public void removeDepartment(Department dept) {
        departments.remove(dept);
        dept.getEvents().remove(this);
    }
}
