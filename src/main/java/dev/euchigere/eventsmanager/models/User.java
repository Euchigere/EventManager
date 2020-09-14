package dev.euchigere.eventsmanager.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer rank=0;
    private String firstName;
    private String lastName;
    private String role;
    private String gender;
    private String contact;
    private String email;
    private LocalDate dob;
    private String password;

    @ManyToOne
    private Department department;

    public void setDob(String dob) {
        this.dob = LocalDate.parse(dob);
    }
}
