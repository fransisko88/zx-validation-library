package com.zhers.validation.validator;

import com.zhers.validation.annotation.ZxCharacterSize;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

/**
 * Validator for {@link ZxCharacterSize} annotation.
 * Validates that a string's length is within the specified minimum and maximum size.
 */
public class CharacterSizeValidator implements ConstraintValidator<ZxCharacterSize, String> {

    private String fieldName;
    private String message;
    private int min;
    private int max;

    @Override
    public void initialize(ZxCharacterSize constraintAnnotation) {
        this.fieldName = constraintAnnotation.fieldName();
        this.message = constraintAnnotation.message();
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Use provided fieldName or fallback to "Field"
        String errorMessage = "";
        if(fieldName !=null || fieldName.isEmpty()){
            errorMessage = message;
        }else{
            errorMessage = fieldName + " " + message;
        }
        // Build custom message
       

        // Set custom message in constraint context
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorMessage).addConstraintViolation();

        // Validation logic
        if (value == null) {
            return true; // Null value can be valid based on use case
        }
        int length = value.length();
        return length >= min && length <= max;
    }
}
