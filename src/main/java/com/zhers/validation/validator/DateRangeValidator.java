package com.zhers.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.zhers.validation.annotation.ZxDateRange;

/**
 * Validator for {@link ZxDateRange} annotation.
 * Validates that a date is within the specified range.
 */
public class DateRangeValidator implements ConstraintValidator<ZxDateRange, LocalDate> {
    private LocalDate minDate;
    private LocalDate maxDate;

    @Override
    public void initialize(ZxDateRange constraintAnnotation) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            if (!constraintAnnotation.minDate().isEmpty()) {
                this.minDate = LocalDate.parse(constraintAnnotation.minDate(), formatter);
            }
            if (!constraintAnnotation.maxDate().isEmpty()) {
                this.maxDate = LocalDate.parse(constraintAnnotation.maxDate(), formatter);
            }
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format in DateRange annotation", e);
        }
    }

    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext context) {
        if (date == null) {
            return true; // Use @NotNull for null checks
        }

        if (minDate != null && date.isBefore(minDate)) {
            return false;
        }
        if (maxDate != null && date.isAfter(maxDate)) {
            return false;
        }
        return true;
    }
}