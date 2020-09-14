package dev.euchigere.eventsmanager.dto;

import dev.euchigere.eventsmanager.models.Department;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Data
@Component
public class UserDto {
    private Long id;
    private Integer rank;
    private String firstName;
    private String lastName;
    private String role;
    private String gender;
    private String contact;
    private String email;
    private LocalDate dob;

    private String message;
    private boolean status;

    private Department department;

    public void setDob(String dob) {
        this.dob = LocalDate.parse(dob);
    }
}
