package com.teducci.entites;

import com.teducci.commons.constants.DefinitionsUtil;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "course", schema = DefinitionsUtil.SCHEMA_QUARKUS)
public class CourseEntity {
    @Id
    @SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "course_sequence")
    private Long id;
    private String name;
    private String teacher;
}
