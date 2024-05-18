package edu.chnu.ua.crossplatform.books.book;

import org.springframework.util.Assert;
import org.testcontainers.shaded.com.google.common.base.MoreObjects;

import java.util.Objects;

public class Title {
    private String title;

    protected Title() {
    }

    public Title(String title) {
        Assert.hasText(title, "title cannot be empty");
        this.title = title;
    }

    public String asString() {
        return title;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Title that = (Title) obj;
        return Objects.equals(title, that.title);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("title", title)
                .toString();
    }
}
