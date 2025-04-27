package com.zhers.validation.validator;

import com.zhers.validation.annotation.ZxNotBlank;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

/**
 * Validator for {@link ZxNotBlank} annotation.
 * Ensures that a string is not null and not empty (after trimming).
 */
public class NotBlankValidator implements ConstraintValidator<ZxNotBlank, String> {
    private String fieldName;
    private String message;

    @Override
    public void initialize(ZxNotBlank constraintAnnotation) {
        this.fieldName = constraintAnnotation.fieldName();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Use provided fieldName or fallback to "Field"
        String effectiveFieldName = StringUtils.hasText(fieldName) ? fieldName : "Field";
        // Build custom message
        String errorMessage = effectiveFieldName + " " + message;

        // Set custom message in constraint context
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorMessage).addConstraintViolation();

        // Validation logic
        return StringUtils.hasText(value);
    }
}