package com.example.hm49.DTO;

import com.example.hm49.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.security.Timestamp;
import java.util.List;
@AllArgsConstructor
@Getter
@Setter
@Data

public class VacanciesDto {
    private int id;

    private String name;
    private String description;

    private int categoryId;

    private double salary;
    private int expFrom;
    private int expTo;
    private boolean isActive;
    private int authorId;
    private Timestamp createdDate;

    private Timestamp updateTime;

    private List<Integer> applicantIds;
}
