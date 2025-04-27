package com.zhers.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.zhers.validation.validator.PhoneNumberValidator;

/**
 * @author   Fransisko Sihombing
 * @github   fransisko88
 * @version  1.0.0
 * @since    2025-04-27
 */
/**
 * Annotation to validate phone number format (e.g., +62 or 08 prefix for Indonesia).
 */
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ZxValidPhoneNumber {
    String message() default "Invalid phone number format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String countryCode() default "+62";
}