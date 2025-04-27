package com.zhers.validation.validator;

import com.zhers.validation.annotation.ZxPastDate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

/**
 * Validator for {@link ZxPastDate} annotation.
 * Validates that a date is in the past (before the current date).
 */
public class PastDateValidator implements ConstraintValidator<ZxPastDate, LocalDate> {

    private String fieldName;
    private String message;

    @Override
    public void initialize(ZxPastDate constraintAnnotation) {
        this.fieldName = constraintAnnotation.fieldName();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        String errorMessage = "";
        if(fieldName !=null || fieldName.isEmpty()){
            errorMessage = message;
        }else{
            errorMessage = fieldName + " " + message;
        }

        // Set custom message in constraint context
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorMessage).addConstraintViolation();

        // Validation logic
        if (value == null || value.isAfter(LocalDate.now())) {
            return false;
        }
        return true;
    }
}
