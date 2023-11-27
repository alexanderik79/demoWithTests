package com.example.demowithtests.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidGenderException extends RuntimeException {
    public InvalidGenderException(String gender) {
        super("Invalid gender: " + gender+". Must be Male or Female");
    }
}
