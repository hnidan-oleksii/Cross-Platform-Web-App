package edu.chnu.ua.crossplatform.book;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PublisherAttributeConverter implements AttributeConverter<Publisher, String> {
    @Override
    public String convertToDatabaseColumn(Publisher publisher) {
        return publisher.asString();
    }

    @Override
    public Publisher convertToEntityAttribute(String s) {
        return new Publisher(s);
    }
}
