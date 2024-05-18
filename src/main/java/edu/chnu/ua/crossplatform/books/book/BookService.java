package edu.chnu.ua.crossplatform.books.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Book createBook(CreateBookParameters parameters);
    Page<Book> getBooks(Pageable pageable);
}
