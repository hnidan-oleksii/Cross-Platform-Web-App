package edu.chnu.ua.crossplatform.books;

import edu.chnu.ua.crossplatform.books.book.BookService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotInAcceptableRangeValidator implements ConstraintValidator<NotInAcceptableRange, Integer> {
    private final BookService bookService;

    public NotInAcceptableRangeValidator(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void initialize(NotInAcceptableRange constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer year, ConstraintValidatorContext constraintValidatorContext) {
        if (!bookService.yearIsInAcceptableRange(year)) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("{NotInAcceptableRange}")
                    .addPropertyNode("publishingYear")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
