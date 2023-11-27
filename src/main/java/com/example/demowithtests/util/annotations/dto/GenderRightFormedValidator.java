package com.example.demowithtests.util.annotations.dto;

import com.example.demowithtests.domain.Gender;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GenderRightFormedValidator implements ConstraintValidator<GenderRightFormed, Gender> {
    @Override
    public boolean isValid(Gender value, ConstraintValidatorContext context) {
        return value != null && (value == Gender.Male || value == Gender.Female);
    }
}
