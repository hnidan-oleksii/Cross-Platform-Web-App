package edu.chnu.ua.crossplatform.books.book;

import org.springframework.util.Assert;
import org.testcontainers.shaded.com.google.common.base.MoreObjects;

import java.util.Objects;

public class Publisher {
    private String publisher;

    protected Publisher() {
    }

    public Publisher(String publisher) {
        Assert.hasText(publisher, "publisher cannot be empty");
        this.publisher = publisher;
    }

    public String asString() {
        return publisher;
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisher);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Publisher that = (Publisher) obj;
        return Objects.equals(publisher, that.publisher);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("publisher", publisher)
                .toString();
    }
}
