package edu.chnu.ua.crossplatform.books.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Year;
import java.util.Optional;

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
    public Optional<Book> getBook(BookId bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public Page<Book> getBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public boolean bookWithTitleExists(Title title) {
        return bookRepository.existsByTitle(title);
    }

    @Override
    public boolean yearIsInAcceptableRange(Integer year) {
        return year <= Year.now().getValue() && year >= 1500;
    }

    @Override
    public Book editBook(BookId bookId, EditBookParameters bookParameters) {
        var book = bookRepository
                .findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));

        if (bookParameters.getVersion() != book.getVersion()) {
            throw new ObjectOptimisticLockingFailureException(Book.class, book.getId().asString());
        }
        bookParameters.update(book);
        return book;
    }

    @Override
    public void deleteBook(BookId bookId) {
        bookRepository.deleteById(bookId);
    }
}
