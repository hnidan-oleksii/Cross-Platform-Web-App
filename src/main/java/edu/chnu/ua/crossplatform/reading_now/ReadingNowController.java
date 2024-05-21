package edu.chnu.ua.crossplatform.reading_now;

import edu.chnu.ua.crossplatform.books.*;
import edu.chnu.ua.crossplatform.books.book.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value ={"/", "reading-now"})
public class ReadingNowController {
    private final BookService bookService;

    public ReadingNowController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public String readingNow(Model model, @SortDefault.SortDefaults({@SortDefault("title")}) Pageable pageable) {
        model.addAttribute("pageTitle", "Reading Now");
        model.addAttribute("activeMenuItem", "reading-now");
        model.addAttribute("books", bookService.getBooks(pageable));
        return "books/books";
    }

    @GetMapping(value = {"/create", "/reading-now/create"})
    public String createBookForm(Model model) {
        model.addAttribute("book", new CreateBookFormData());
        model.addAttribute("genres", List.of(Genre.values()));
        model.addAttribute("activeMenuItem", "reading-now");
        return "books/edit";
    }

    @PostMapping(value = {"/create", "/reading-now/create"})
    public String createBook(@Validated(CreateBookValidationGroupSequence.class)
                                 @ModelAttribute("book") CreateBookFormData formData,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("genres", List.of(Genre.values()));
            return "books/edit";
        }
        bookService.createBook(formData.toParameters());
        return "redirect:/";
    }

    @GetMapping(value = {"/{id}", "/reading-now/{id}"})
    public String editBookForm(@PathVariable("id") BookId bookId, Model model) {
        Book book = bookService
                .getBook(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));

        model.addAttribute("book", EditBookFormData.fromBook(book));
        model.addAttribute("genres", List.of(Genre.values()));
        model.addAttribute("editMode", EditMode.UPDATE);
        model.addAttribute("activeMenuItem", "reading-now");
        return "books/edit";
    }

    @PostMapping(value = {"/{id}", "/reading-now/{id}"})
    public String editBook(@PathVariable("id") BookId bookId,
                           @Validated(EditBookValidationGroupSequence.class)
                               @ModelAttribute("book") EditBookFormData formData,
                           BindingResult bindingResult,
                           Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("genres", List.of(Genre.values()));
            model.addAttribute("editMode", EditMode.UPDATE);
            return "books/edit";
        }
        bookService.editBook(bookId, formData.toParameters());
        return "redirect:/";
    }

    @PostMapping(value = {"/{id}/delete", "/reading-now/{id}/delete"})
    public String deleteBook(@PathVariable("id") BookId bookId) {
        Book book = bookService
                .getBook(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));

        bookService.deleteBook(bookId);
        return "redirect:/";
    }
}
