package edu.chnu.ua.crossplatform.books.book;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(BookId bookid) {
        super(String.format("Book with id %s not found", bookid.asString()));
    }
}
