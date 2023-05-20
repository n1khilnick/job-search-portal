package com.geekster.jobsearchportal.model;

import com.geekster.jobsearchportal.enums.JobType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
    @Entity
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Title is required !!")
    private String title;

    @NotBlank(message = "You should provide job description !!")
    private String description;

    @NotBlank(message = "Location is required !!")
    private String location;

    @NotNull(message = "Salary field is required !!")
    private Double salary;

    @NotBlank(message = "Company name is required !!")
    private String companyName;

    private String employerName;

    @Enumerated(EnumType.STRING)
    private JobType jobType;

    private LocalDate appliedDate;
}
