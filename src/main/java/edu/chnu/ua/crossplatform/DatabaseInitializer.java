package edu.chnu.ua.crossplatform;

import com.github.javafaker.Book;
import com.github.javafaker.Faker;
import edu.chnu.ua.crossplatform.books.book.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@Profile("init-db")
public class DatabaseInitializer implements CommandLineRunner {

    private final Faker faker = new Faker();
    private final BookService bookService;

    public DatabaseInitializer(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) {
        Random random = new Random();
        List<Genre> genres = List.of(Genre.values());
        for (int i = 0; i < 20; i++) {
            bookService.createBook(createRandomBookParameters(random, genres));
        }
    }

    private CreateBookParameters createRandomBookParameters(Random random, List<Genre> genres) {
        Book book = faker.book();
        Title title = new Title(book.title());
        Author author = new Author(book.author());
        Genre genre = genres.get(random.nextInt(genres.size()));
        Publisher publisher = new Publisher(book.publisher());
        int publishingYear = random.nextInt(520) + 1500;

        return new CreateBookParameters(title, author, genre, publisher, publishingYear);
    }
}
