package com.zhers.validation.validator;

import com.zhers.validation.annotation.ZxValidPhoneNumber;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Validator for {@link ZxValidPhoneNumber} annotation.
 * Validates phone number format based on country code.
 */
public class PhoneNumberValidator implements ConstraintValidator<ZxValidPhoneNumber, String> {
    private String countryCode;

    @Override
    public void initialize(ZxValidPhoneNumber constraintAnnotation) {
        this.countryCode = constraintAnnotation.countryCode();
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        if (phoneNumber == null) {
            return true; // Use @NotNull for null checks
        }

        // Example regex for Indonesian phone numbers
        String regex = countryCode.equals("+62") ? "^\\+62\\d{9,12}$" : "^08\\d{8,11}$";
        return phoneNumber.matches(regex);
    }
}