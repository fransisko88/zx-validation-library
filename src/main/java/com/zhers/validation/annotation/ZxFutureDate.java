package com.zhers.validation.annotation;

import com.zhers.validation.validator.FutureDateValidator;
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
 * Annotation to validate that a date is in the future.
 */
@Documented
@Constraint(validatedBy = FutureDateValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ZxFutureDate {
    String message() default "Date must be in the future";
    Class<?>[] groups() default {};
    String fieldName() default "";
    Class<? extends Payload>[] payload() default {};
}
