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

    @DateTimeFormat(iso= DateTimeFormat.ISO.TIME, pattern = "HH:mm")
    private LocalTime time;
    private String attendanceType;
    private Long noOfAttendees = 0l;

    @ManyToMany()
    private Set<Department> departments = new HashSet<>();

    @Transient
    private List<Long> deptIds;

    public void setTime(String time) {
        this.time = LocalTime.parse(time);
    }

    public String getTime() {
        if (this.time == null) {
            return null;
        }
        return this.time.toString();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Event)) return false;

        Event event = (Event) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(getId(), event.getId())
                .append(getTitle(), event.getTitle())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(getId())
                .append(getTitle())
                .toHashCode();
    }
}
