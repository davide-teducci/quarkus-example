package com.teducci.controllers;

import com.teducci.commons.exceptions.ParameterInvalidException;
import com.teducci.dtos.StudentDto;
import com.teducci.commons.mappers.StudentMapper;
import com.teducci.entites.StudentEntity;
import com.teducci.services.StudentService;
import io.smallrye.common.constraint.NotNull;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.security.Principal;

@Path("/students")
public class StudentController {

    @Inject
    private StudentService studentService;

    @Inject
    private StudentMapper studentMapper;

    @Inject
    private Principal principal;

    @Inject
    private JsonWebToken jsonWebToken;

    @GET
    public Response findAll() {
        return Response.ok(studentService.findAll()
                .stream().map(studentEntity -> studentMapper.toDto(studentEntity))).build();
    }

    @GET
    @Path("/q")
    public Response findByEmail(@QueryParam("email") String email) throws ParameterInvalidException {
        StudentDto response = studentMapper.toDto(studentService.findByEmail(email));
        return Response.ok(response).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"admin", "professor", "student"})
    public Response findById(@PathParam("id") Long id, @Context HttpHeaders headers) {
        System.out.println(principal.getName());
        System.out.println(jsonWebToken.getGroups());
        return Response.ok(studentMapper.toDto(studentService.findByID(id))).build();
    }

    @POST
    @Transactional
    public Response createStudent(StudentDto student) {
        studentService.createStudent(studentMapper.toEntity(student));
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateStudent(@NotNull @PathParam("id") Long id, StudentDto student) throws NotFoundException {
        StudentEntity entity = studentMapper.toEntity(student);
        entity.setId(id);
        studentService.updateStudent(entity);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteStudent(@NotNull @PathParam("id") Long id) throws NotFoundException {
        studentService.deleteStudent(id);
        return Response.ok().build();
    }
}
