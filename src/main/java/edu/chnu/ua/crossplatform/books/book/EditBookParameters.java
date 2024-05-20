package edu.chnu.ua.crossplatform.books.book;

public class EditBookParameters extends CreateBookParameters {
    private long version;

    public EditBookParameters(long version,
                              Title title,
                              Author author,
                              Genre genre,
                              Publisher publisher,
                              int publishingYear) {
        super(title, author, genre, publisher, publishingYear);
        this.version = version;
    }

    public long getVersion() {
        return version;
    }

    public void update(Book book) {
        book.setTitle(getTitle());
        book.setAuthor(getAuthor());
        book.setGenre(getGenre());
        book.setPublisher(getPublisher());
        book.setPublishingYear(getPublishingYear());
    }
}
