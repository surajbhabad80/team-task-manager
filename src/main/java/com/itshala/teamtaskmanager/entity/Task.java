package com.itshala.teamtaskmanager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    private String description;

    @NotBlank
    private String status; // PENDING, IN_PROGRESS, COMPLETED

    @NotNull
    private LocalDate dueDate;

    @ManyToOne
    private Project project;

    @ManyToOne
    private User assignedUser;
}