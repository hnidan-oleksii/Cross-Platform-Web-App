package edu.chnu.ua.crossplatform.book;

import io.github.wimdeblauwe.jpearl.AbstractEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tt_book")
public class Book extends AbstractEntity<BookId> {

    /**
     * Default constructor for JPA
     */
    protected Book() {
    }

    public Book(BookId id) {
        super(id);
    }
}