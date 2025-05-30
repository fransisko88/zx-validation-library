# Custom Validation Library

A Spring Boot library providing custom validation annotations for common use cases, designed to simplify data validation.

## Features

This library includes the following validation annotations:

- **`@DateRange`**: Validates that a date is within a specified range.
- **`@ZxValidPhoneNumber`**: Validates phone numbers with specific country code prefixes (e.g., +62 or 08 for Indonesia).
- **`@ZxEmail`**: Validates email addresses following standard email format rules.
- **`@ZxPastDate`**: Validates that a date field contains a date in the past.
- **`@ZxFutureDate`**: Validates that a date field contains a date in the future.
- **`@ZxCharacter`**: Validates that a string contains only alphabetic characters.
- **`@ZxNotNull`**: Validates that a field value is not `null`.
- **`@ZxNotBlank`**: Validates that a string field is not empty and contains at least one non-whitespace character.

## Installation

To integrate this library into your Maven project, add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.zhers</groupId>
    <artifactId>custom-validation-library</artifactId>
    <version>1.0.0</version>
</dependency>