package com.example.hm49.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class WorkExperienceInfo {
    private int id;
    private int resumeId;
    @NotNull(message = "Год не может быть пустым")

    private int years;
    @NotNull(message = "Имя не может быть пустым")
    private String companyName;
    @NotNull(message = "Position не может быть пустым")

    private String position;
    private String responsibilities;
}
