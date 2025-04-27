package com.zhers.validation.annotation;

import com.zhers.validation.validator.CharacterSizeValidator;
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
 * Annotation to validate the size of a character field.
 */
@Documented
@Constraint(validatedBy = CharacterSizeValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ZxCharacterSize {
    int min() default 0;
    int max() default Integer.MAX_VALUE;
    String fieldName() default "";

    String message() default "size length must be between {min} and {max}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
