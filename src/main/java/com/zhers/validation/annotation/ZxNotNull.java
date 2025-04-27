package com.zhers.validation.annotation;

import com.zhers.validation.validator.NotNullValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author   Fransisko Sihombing
 * @github   fransisko88
 * @version  1.0.0
 * @since    2025-04-27
 */
/**
 * Annotation to validate that a field is not null.
 */
@Documented
@Constraint(validatedBy = NotNullValidator.class)
@ReportAsSingleViolation
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ZxNotNull {
    String message() default "cannot be null";

    String fieldName() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}