package com.teducci.commons.exceptions;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ParameterInvalidHandler implements ExceptionMapper<ParameterInvalidException> {

    @ConfigProperty(name = "exception.message.parameter-invalid")
    String parameterInvalidMessage;

    @Override
    public Response toResponse(ParameterInvalidException e) {
        ErrorMessage error = new ErrorMessage();
        error.setMessage(parameterInvalidMessage + ": " + e.getMessage());
        return Response.
                status(Response.Status.BAD_REQUEST)
                .entity(error)
                .build();
    }
}
