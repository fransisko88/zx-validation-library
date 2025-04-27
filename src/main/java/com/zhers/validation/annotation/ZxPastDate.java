package com.zhers.validation.annotation;

import com.zhers.validation.validator.PastDateValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * @author   Fransisko Sihombing
 * @github   fransisko88
 * @version  1.0.0
 * @since    2025-04-27
 */
/**
 * Annotation to validate that a date is in the past.
 */
@Documented
@Constraint(validatedBy = PastDateValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ZxPastDate {
    String message() default "Date must be in the past";
    Class<?>[] groups() default {};
    String fieldName() default "";
    Class<? extends Payload>[] payload() default {};
}
