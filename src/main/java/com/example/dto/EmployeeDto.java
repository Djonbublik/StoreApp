package com.example.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class EmployeeDto {

    private Long id;

    private String lastName;// фамилия

    private String firstName;

    private String patronymic; // отчество

    private Date birthday; // день рождения

    private Long  position; // id должности

    private Boolean gender;// пол
}
