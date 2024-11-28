package ru.kors.springstudents.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Builder;

import java.time.LocalDate;
import java.time.Period;

@Data
@Entity
@Table(name = "STUDENTS")
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    @Column(unique = true)
    private String email;
    @Transient
    private int age;

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
}
