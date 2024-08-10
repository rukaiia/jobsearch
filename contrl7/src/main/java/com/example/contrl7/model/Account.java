package com.example.contrl7.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {
    private Integer id;
    private Integer userId;
    private String currency;
    private Double balance;


}

