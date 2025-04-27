package com.zhers.validation.validator;

import com.zhers.validation.annotation.ZxNotNull;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

/**
 * Validator for {@link ZxNotNull} annotation.
 * Ensures that a field is not null.
 */
public class NotNullValidator implements ConstraintValidator<ZxNotNull, Object> {
    private String fieldName;
    private String message;

    @Override
    public void initialize(ZxNotNull constraintAnnotation) {
        this.fieldName = constraintAnnotation.fieldName();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        // Use provided fieldName or fallback to "Field"
        String effectiveFieldName = StringUtils.hasText(fieldName) ? fieldName : "Field";
        // Build custom message
        String errorMessage = effectiveFieldName + " " + message;

        // Set custom message in constraint context
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorMessage).addConstraintViolation();

        // Validation logic
        return value != null;
    }
}