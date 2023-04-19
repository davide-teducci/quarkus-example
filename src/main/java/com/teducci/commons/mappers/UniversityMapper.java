package com.teducci.commons.mappers;

import com.teducci.dtos.StudentDto;
import com.teducci.entites.StudentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface UniversityMapper {

    StudentDto toDto(StudentEntity entity);
    StudentEntity toEntity(StudentDto dto);

}
