package com.teducci.dtos;

import lombok.Data;

import java.util.List;

@Data
public class StudentDto {

    private String firstname;
    private String lastname;
    private int age;
    private String email;
    private UniversityDto university;
    private List<CourseDto> courses;
}
