package com.zhers.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.zhers.validation.validator.DateRangeValidator;

/**
 * @author   Fransisko Sihombing
 * @github   fransisko88
 * @version  1.0.0
 * @since    2025-04-27
 */
/**
 * Annotation to validate that a date is within a specified range.
 */
@Constraint(validatedBy = DateRangeValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ZxDateRange {
    String message() default "Date must be within valid range";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String minDate() default ""; // Format: yyyy-MM-dd
    String maxDate() default "";
}