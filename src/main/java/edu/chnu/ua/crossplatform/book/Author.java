package edu.chnu.ua.crossplatform.book;

import org.springframework.util.Assert;
import org.testcontainers.shaded.com.google.common.base.MoreObjects;

import java.util.Objects;

public class Author {
    private String author;

    protected Author() {
    }

    public Author(String author) {
        Assert.hasText(author, "author cannot be blank");
        this.author = author;
    }

    public String asString() {
        return author;
    }

    @Override
    public int hashCode() {
        return Objects.hash(author);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Author that = (Author) obj;
        return Objects.equals(author, that.author);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("author", author)
                .toString();
    }
}
