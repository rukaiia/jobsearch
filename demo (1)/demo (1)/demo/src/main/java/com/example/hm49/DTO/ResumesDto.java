package com.example.hm49.DTO;

import lombok.*;

import java.security.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@Data
public class ResumesDto {
    private int id;

    private int applicantId;

    private String name;
    private int categoryId;

    private double salary;
    private boolean isActive;
    private Timestamp createdDate;

    private Timestamp updateTime;


    public ResumesDto(int id, int applicantId, String name, int categoryId, double salary, boolean active, java.sql.Timestamp createdDate, java.sql.Timestamp updateTime) {



    }
}
