package edu.chnu.ua.crossplatform.books;

import edu.chnu.ua.crossplatform.books.book.*;

public class EditBookFormData extends CreateBookFormData {
    private String id;
    private long version;

    public static EditBookFormData fromBook(Book book) {
        EditBookFormData result = new EditBookFormData();

        result.setId(book.getId().asString());
        result.setVersion(book.getVersion());
        result.setTitle(book.getTitle().asString());
        result.setAuthor(book.getAuthor().asString());
        result.setGenre(book.getGenre());
        result.setPublisher(book.getTitle().asString());
        result.setPublishingYear(book.getPublishingYear());

        return result;
    }

    public EditBookParameters toParameters() {
        return new EditBookParameters(
                version,
                new Title(getTitle()),
                new Author(getAuthor()),
                getGenre(),
                new Publisher(getPublisher()),
                getPublishingYear()
        );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
