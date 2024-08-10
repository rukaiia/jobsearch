package com.example.hm49.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Data
public class WorkExperienceInfoDto {
    private int id;
    private int resumeId;

    private int years;
    private String companyName;

    private String position;
    private String responsibilities;
}
