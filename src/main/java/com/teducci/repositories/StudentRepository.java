package com.teducci.repositories;

import com.teducci.entites.StudentEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StudentRepository implements PanacheRepository<StudentEntity> {

    public StudentEntity findByEmail(String email) {
        var query = "SELECT s FROM StudentEntity s WHERE UPPER(s.email) LIKE ?1";
        email = "%" + email.toUpperCase() + "%";
        return find(query, email).singleResult();
    }

}
