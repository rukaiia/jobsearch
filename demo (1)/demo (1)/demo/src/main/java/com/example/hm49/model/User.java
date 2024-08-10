package com.example.hm49.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    private int id;
    @NotNull(message = "Имя не может быть пустым")
    @Size(min = 2, max = 30, message = "Имя должно быть от 2 до 30 символов")
    private String name;
    @NotNull(message = "Фамилия не может быть пустой")
    @Size(min = 2, max = 30, message = "Фамилия должна быть от 2 до 30 символов")
    private String surname;
    private int age;
    @NotNull(message = "Email не может быть пустым")
    @Email(message = "Некорректный формат email")
    private String email;
    @NotNull(message = "Пароль не может быть пустым")
    @Size(min = 8, message = "Пароль должен быть не менее 8 символов")
    private String password;
    @NotNull(message = "Номер телефона не может быть пустым")
    @Pattern(regexp = "\\+?996", message = "Некорректный формат номера телефона")
    private String phoneNumber;
    private String avatar;
    private String accountType;




}
