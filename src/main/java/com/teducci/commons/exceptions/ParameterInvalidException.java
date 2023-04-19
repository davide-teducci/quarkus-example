package com.teducci.commons.exceptions;

import java.io.Serializable;

public class ParameterInvalidException extends Exception implements Serializable {

    private static final long serialVersionUID = 1L;

    public ParameterInvalidException() {
        super();
    }

    public ParameterInvalidException(String message) {
        super(message);
    }

    public ParameterInvalidException(String message, Exception e) {
        super(message, e);
    }
}
