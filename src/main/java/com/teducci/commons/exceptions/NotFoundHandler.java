package com.teducci.commons.exceptions;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundHandler implements ExceptionMapper<NotFoundException>  {
    @Override
    public Response toResponse(NotFoundException e) {
        ErrorMessage error = new ErrorMessage();
        error.setMessage(e.getMessage());
        return Response.
                status(Response.Status.BAD_REQUEST)
                .entity(error)
                .build();
    }
}
