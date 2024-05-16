package edu.chnu.ua.crossplatform.book;

public class CreateBookParameters {
    private final Title title;
    private final Author author;
    private final Genre genre;
    private final Publisher publisher;
    private final int publishingYear;

    public CreateBookParameters(Title title,
                                Author author,
                                Genre genre,
                                Publisher publisher,
                                int publishingYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.publishingYear = publishingYear;
    }

    public Title getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public int getPublishingYear() {
        return publishingYear;
    }
}
