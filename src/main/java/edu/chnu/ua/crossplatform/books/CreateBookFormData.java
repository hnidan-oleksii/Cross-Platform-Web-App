package edu.chnu.ua.crossplatform.books;

import edu.chnu.ua.crossplatform.books.book.*;

public class CreateBookFormData {
    private String title;
    private String author;
    private Genre genre;
    private String publisher;
    private int publishingYear;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public CreateBookParameters toParameters() {
        return new CreateBookParameters(
                new Title(title),
                new Author(author),
                genre,
                new Publisher(publisher),
                publishingYear
        );
    }
}
