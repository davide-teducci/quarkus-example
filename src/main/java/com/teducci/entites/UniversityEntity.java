package com.teducci.entites;

import com.teducci.commons.constants.DefinitionsUtil;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "university", schema = DefinitionsUtil.SCHEMA_QUARKUS)
public class UniversityEntity {

    @Id
    @SequenceGenerator(name = "university_sequence", sequenceName = "university_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "university_sequence")
    private Long id;
    private String name;
    private String email;
    private String city;

}
