package edu.chnu.ua.crossplatform.books.book;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StringToBookIdConverter implements Converter<String, BookId> {
    @Override
    public BookId convert(@NotNull String s) {
        return new BookId(UUID.fromString(s));
    }
}
