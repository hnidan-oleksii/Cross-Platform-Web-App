package edu.chnu.ua.crossplatform.books;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotInAcceptableRangeValidator.class)
public @interface NotInAcceptableRange {
    String message() default "{NotInAcceptableRange}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
