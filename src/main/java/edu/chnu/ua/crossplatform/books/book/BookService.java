package edu.chnu.ua.crossplatform.books.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BookService {
    Book createBook(CreateBookParameters parameters);
    Optional<Book> getBook(BookId bookId);
    Page<Book> getBooks(Pageable pageable);
    boolean bookWithTitleExists(Title title);
    boolean yearIsInAcceptableRange(Integer year);
    Book editBook(BookId bookId, EditBookParameters bookParameters);
    void deleteBook(BookId bookId);
}
