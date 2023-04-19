package com.teducci.entites;

import com.teducci.commons.constants.DefinitionsUtil;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "student", schema = DefinitionsUtil.SCHEMA_QUARKUS)
public class StudentEntity {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "student_sequence")
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String email;
    @ManyToOne
    @JoinColumn(name = "university_id")
    private UniversityEntity university;

    @ManyToMany
    @JoinTable(name = "student_course",
            joinColumns = { @JoinColumn(name = "student_id") },
            inverseJoinColumns = { @JoinColumn(name = "course_id") }
    )
    List<CourseEntity> courses;

}
