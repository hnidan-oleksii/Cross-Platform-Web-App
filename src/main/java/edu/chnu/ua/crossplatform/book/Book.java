package edu.chnu.ua.crossplatform.book;

import io.github.wimdeblauwe.jpearl.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "tt_book")
public class Book extends AbstractEntity<BookId> {
    @NotNull
    private Title title;

    @NotNull
    private Author author;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @NotNull
    private Publisher publisher;

    @NotNull
    private int publishingYear;

    /**
     * Default constructor for JPA
     */
    protected Book() {
    }

    public Book(BookId id,
                Title title,
                Author author,
                Genre genre,
                Publisher publisher,
                int publishingYear) {
        super(id);
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.publishingYear = publishingYear;
    }

    public @NotNull Title getTitle() {
        return title;
    }

    public @NotNull Author getAuthor() {
        return author;
    }

    public @NotNull Genre getGenre() {
        return genre;
    }

    public @NotNull Publisher getPublisher() {
        return publisher;
    }

    public @NotNull int getPublishingYear() {
        return publishingYear;
    }
}