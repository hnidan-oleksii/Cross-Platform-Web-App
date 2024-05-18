package edu.chnu.ua.crossplatform.books.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(CreateBookParameters parameters) {
        BookId bookId = bookRepository.nextId();
        var book = new Book(
                bookId,
                parameters.getTitle(),
                parameters.getAuthor(),
                parameters.getGenre(),
                parameters.getPublisher(),
                parameters.getPublishingYear()
        );
        return bookRepository.save(book);
    }

    @Override
    public Page<Book> getBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
}
