package com.example.demowithtests.util.annotations.dto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CountryNameRightFormedValidator implements ConstraintValidator<CountryNameRightFormed, String> {

    @Override
    public boolean isValid(String country, ConstraintValidatorContext constraintValidatorContext) {
        if (country == null)
            return true;
        return country.matches("^[a-zA-Z ]+$");
    }
}
