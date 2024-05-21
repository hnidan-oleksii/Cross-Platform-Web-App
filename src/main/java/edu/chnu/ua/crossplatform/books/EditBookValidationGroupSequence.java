package edu.chnu.ua.crossplatform.books;

import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;

@GroupSequence({Default.class, BookValidationGroupOne.class})
public interface EditBookValidationGroupSequence {
}
