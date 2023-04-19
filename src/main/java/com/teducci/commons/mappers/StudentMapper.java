package com.teducci.commons.mappers;

import com.teducci.dtos.StudentDto;
import com.teducci.entites.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "cdi")
public interface StudentMapper {

    @Mappings({
            @Mapping(target = "lastname", source = "surname"),
            @Mapping(target = "firstname", source = "name")
    })
    StudentDto toDto(StudentEntity entity);

    @Mappings({
            @Mapping(target = "surname", source = "lastname"),
            @Mapping(target = "name", source = "firstname")
    })
    StudentEntity toEntity(StudentDto dto);
}
