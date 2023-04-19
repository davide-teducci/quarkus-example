package com.teducci.commons.mappers;

import com.teducci.dtos.CourseDto;
import com.teducci.entites.CourseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface CourseMapper {

    CourseDto toDto(CourseEntity entity);

    CourseEntity toEntity(CourseDto dto);

}
