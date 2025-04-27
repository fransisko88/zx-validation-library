package com.zhers.validation.validator;

import com.zhers.validation.annotation.ZxFutureDate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

/**
 * Validator for {@link ZxFutureDate} annotation.
 * Validates that a date is in the future (after the current date).
 */
public class FutureDateValidator implements ConstraintValidator<ZxFutureDate, LocalDate> {

    private String fieldName;
    private String message;

    @Override
    public void initialize(ZxFutureDate constraintAnnotation) {
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
        if (value == null || value.isBefore(LocalDate.now())) {
            return false;
        }
        return true;
    }
}
