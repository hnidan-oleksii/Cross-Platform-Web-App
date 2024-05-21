package edu.chnu.ua.crossplatform.books;

import edu.chnu.ua.crossplatform.books.book.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@NotExistingBook(groups = BookValidationGroupTwo.class)
public class CreateBookFormData {
    @NotBlank
    @Size(max = 255, groups = BookValidationGroupOne.class)
    private String title;

    @NotBlank
    @Size(max = 255, groups = BookValidationGroupOne.class)
    private String author;

    private Genre genre;

    @NotBlank
    @Size(max = 255, groups = BookValidationGroupOne.class)
    private String publisher;

    @NotNull
    @Digits(integer = 4, fraction = 0, groups = BookValidationGroupOne.class)
    @NotInAcceptableRange(groups = BookValidationGroupOne.class)
    private Integer publishingYear;

    private long version;

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

    public Integer getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(Integer publishingYear) {
        this.publishingYear = publishingYear;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
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
