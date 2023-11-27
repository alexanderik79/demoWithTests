package com.example.demowithtests.util.annotations.dto;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The annotation verifies that the country is spelled correctly.
 * <p>
 * Condition: The string must be two characters long and be an uppercase.
 * <p>
 * Throws: MethodArgumentNotValidException if the string does not meet the conditions.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CountryNameRightFormedValidator.class)
public @interface CountryNameRightFormed {
    String message() default "Country name must be with letters only";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
