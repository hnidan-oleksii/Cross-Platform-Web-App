package edu.chnu.ua.crossplatform.book;

import io.github.wimdeblauwe.jpearl.InMemoryUniqueIdGenerator;
import io.github.wimdeblauwe.jpearl.UniqueIdGenerator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("data-jpa-test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BookRepositoryTest {
    private final BookRepository repository;
    private final JdbcTemplate jdbcTemplate;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    BookRepositoryTest(BookRepository repository,
                       JdbcTemplate jdbcTemplate) {
        this.repository = repository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @BeforeEach
    void validatePreconditions() {
        assertThat(repository.count()).isZero();
    }

    @Test
    void testSaveBook() {
        BookId id = repository.nextId();
        repository.save(
                new Book(id,
                new Title("After Dark"),
                new Author("Haruki Murakami"),
                Genre.FANTASY,
                new Publisher("Vintage Books"),
                2008
        ));

        entityManager.flush();

        assertThat(jdbcTemplate.queryForObject("SELECT id FROM tt_book", UUID.class)).isEqualTo(id.getId());
        assertThat(jdbcTemplate.queryForObject("SELECT title FROM tt_book", String.class)).isEqualTo("After Dark");
        assertThat(jdbcTemplate.queryForObject("SELECT author FROM tt_book", String.class)).isEqualTo("Haruki Murakami");
        assertThat(jdbcTemplate.queryForObject("SELECT genre FROM tt_book", Genre.class)).isEqualTo(Genre.FANTASY);
        assertThat(jdbcTemplate.queryForObject("SELECT publisher FROM tt_book", String.class)).isEqualTo("Vintage Books");
        assertThat(jdbcTemplate.queryForObject("SELECT publishing_year FROM tt_book", Integer.class)).isEqualTo(2008);
    }

    @Test
    void testFindAllPageable() {
        saveBooks(8);
        Sort sort = Sort.by(Sort.Direction.ASC, "title");

        assertThat(repository.findAll(PageRequest.of(0, 5, sort)))
                .hasSize(5)
                .extracting(book -> book.getTitle().asString())
                .containsExactly("After Dark 1", "After Dark 2", "After Dark 3", "After Dark 4", "After Dark 5");

        assertThat(repository.findAll(PageRequest.of(1, 5, sort)))
                .hasSize(3)
                .extracting(book -> book.getTitle().asString())
                .containsExactly("After Dark 6", "After Dark 7", "After Dark 8");

        assertThat(repository.findAll(PageRequest.of(3, 5, sort))).isEmpty();
    }

    private void saveBooks(int numberOfBooks) {
        for (int i = 0; i < numberOfBooks; i++) {
            repository.save(new Book(
                    repository.nextId(),
                    new Title(String.format("After Dark %1", i)),
                    new Author("Haruki Murakami"),
                    Genre.FANTASY,
                    new Publisher("Vintage Books"),
                    2008
            ));
        }
    }

    @TestConfiguration
    static class TestConfig {
        @Bean
        public UniqueIdGenerator<UUID> uniqueIdGenerator() {
            return new InMemoryUniqueIdGenerator();
        }
    }
}