package edu.chnu.ua.crossplatform.books.book;

import io.github.wimdeblauwe.jpearl.AbstractVersionedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tt_book")
public class Book extends AbstractVersionedEntity<BookId> {
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

    public void setTitle(@NotNull Title title) {
        this.title = title;
    }

    public void setAuthor(@NotNull Author author) {
        this.author = author;
    }

    public void setGenre(@NotNull Genre genre) {
        this.genre = genre;
    }

    public void setPublisher(@NotNull Publisher publisher) {
        this.publisher = publisher;
    }

    public void setPublishingYear(@NotNull int publishingYear) {
        this.publishingYear = publishingYear;
    }
}