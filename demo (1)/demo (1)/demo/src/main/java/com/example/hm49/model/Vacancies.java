package com.example.hm49.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vacancies {
    private int id;
    @NotNull(message = "Имя не может быть пустым")
    private String name;
    private String description;
    private int categoryId;
    @NotNull(message = "Зарплата не может быть пустым")

    private double salary;
    private int expFrom;
    private int expTo;
    private boolean isActive;
    private int authorId;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private List<User> applicants;
    private int employerId;
    private String title;

    public Vacancies(int id, int employerId, String title, int categoryId, double salary, String description, boolean isActive, Timestamp createdDate) {
        this.id = id;

        this.employerId = employerId;
        this.categoryId = categoryId;
        this.title =title;

        this.salary = salary;
        this.description = description;
        this.isActive = isActive;
        this.createdDate = createdDate;
    }
}
