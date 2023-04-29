package com.epam.lab.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ArgumentException extends ResponseStatusException {
public ArgumentException(HttpStatus status, String cause)
{
    super(status, cause);
}
}
