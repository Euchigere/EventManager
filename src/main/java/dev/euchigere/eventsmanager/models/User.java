package dev.euchigere.eventsmanager.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private String role;
    @NotBlank
    private String gender;
    private String contact;

    @NotBlank
    @Column(unique = true)
    private String email;
    private LocalDate dob;
    @NotBlank
    private String password;

    @ManyToOne
    private Department department;

    public void setDob(String dob) {
        this.dob = LocalDate.parse(dob);
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
