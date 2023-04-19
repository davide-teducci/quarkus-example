package com.teducci.services.impl;

import com.teducci.commons.exceptions.ParameterInvalidException;
import com.teducci.entites.StudentEntity;
import com.teducci.repositories.StudentRepository;
import com.teducci.services.StudentService;
import io.quarkus.runtime.util.StringUtil;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.ws.rs.NotFoundException;
import java.util.List;

@Singleton
public class StudentServiceImpl implements StudentService {

    @Inject
    private StudentRepository studentRepository;

    @Inject
    private EntityManager entityManager;

    @Override
    public StudentEntity findByEmail(String email) throws ParameterInvalidException {
        if(StringUtil.isNullOrEmpty(email.trim())) {
            throw new ParameterInvalidException();
        }
        return studentRepository.findByEmail(email);
    }

    @Override
    public List<StudentEntity> findAll() {
        return studentRepository.findAll().list();
    }

    @Override
    public StudentEntity findByID(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void createStudent(StudentEntity student) {
        studentRepository.persist(student);
    }

    @Override
    public void updateStudent(StudentEntity student) {
        StudentEntity entity = studentRepository.findByIdOptional(student.getId())
                .orElseThrow( () -> new NotFoundException("Student with ID " + student.getId() + " not found"));
        /* entity.setName(student.getName());
        entity.setEmail(student.getEmail());
        entity.setAge(student.getAge());
        entity.setSurname(student.getSurname());
        studentRepository.persist(entity); */
        entityManager.merge(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.findByIdOptional(id)
                .orElseThrow( () -> new NotFoundException("Student with ID " + id + " not found"));
        studentRepository.deleteById(id);
    }
}
