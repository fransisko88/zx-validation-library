package com.zhers.validation.validator;

import com.zhers.validation.annotation.ZxEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

/**
 * Validator for {@link ZxEmail} annotation.
 * Validates that a string is a valid email format.
 */
public class EmailValidator implements ConstraintValidator<ZxEmail, String> {

    private String message;

    @Override
    public void initialize(ZxEmail constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        String errorMessage = message;

        // Set custom message in constraint context
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorMessage).addConstraintViolation();

        // Validation logic (simple email format check)
        if (value == null || !value.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            return false;
        }
        return true;
    }
}
