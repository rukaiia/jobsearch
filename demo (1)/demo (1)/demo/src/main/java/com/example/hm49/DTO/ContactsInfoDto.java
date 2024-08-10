package com.example.hm49.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class ContactsInfoDto {
    private int id;
    private int typeId;
    private int resumeId;
    private String value;
}
