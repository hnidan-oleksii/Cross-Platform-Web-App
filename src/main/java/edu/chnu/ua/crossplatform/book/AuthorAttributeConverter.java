package edu.chnu.ua.crossplatform.book;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AuthorAttributeConverter implements AttributeConverter<Author, String> {
    @Override
    public String convertToDatabaseColumn(Author author) {
        return author.asString();
    }

    @Override
    public Author convertToEntityAttribute(String s) {
        return new Author(s);
    }
}
