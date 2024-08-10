package com.example.hm49.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ContactsInfo {
    private int id;
    private int typeId;
    private int resumeId;
    private String value;
}
