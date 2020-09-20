package dev.euchigere.eventsmanager.dto;

import dev.euchigere.eventsmanager.models.Department;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Component
public class UserDTO {
    private Long id;
    private Integer rank;
    private String firstName;
    private String lastName;
    private String role;
    private String gender;
    private String contact;
    private String email;
    private LocalDate dob;
    private Department department;
}
