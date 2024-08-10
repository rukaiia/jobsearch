package com.example.hm49.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class CategoriesDto {
    private String name;
    private int parent_id;
    private int id;

}
