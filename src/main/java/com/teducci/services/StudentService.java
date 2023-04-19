package com.teducci.services;

import com.teducci.commons.exceptions.ParameterInvalidException;
import com.teducci.entites.StudentEntity;

import java.util.List;

public interface StudentService {
    StudentEntity findByEmail(String email) throws ParameterInvalidException;
    List<StudentEntity> findAll();
    StudentEntity findByID(Long id);
    void createStudent(StudentEntity student);
    void updateStudent(StudentEntity student);
    void deleteStudent(Long id);

}
