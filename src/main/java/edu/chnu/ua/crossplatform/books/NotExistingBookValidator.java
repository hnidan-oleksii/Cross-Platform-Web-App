package edu.chnu.ua.crossplatform.books;

import edu.chnu.ua.crossplatform.books.book.BookService;
import edu.chnu.ua.crossplatform.books.book.Title;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class NotExistingBookValidator implements ConstraintValidator<NotExistingBook, CreateBookFormData> {
    private final BookService bookService;

    @Autowired
    public NotExistingBookValidator(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void initialize(NotExistingBook constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(CreateBookFormData createBookFormData, ConstraintValidatorContext constraintValidatorContext) {
        if (bookService.bookWithTitleExists(new Title(createBookFormData.getTitle()))) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("{BookAlreadyExists}")
                    .addPropertyNode("title")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
