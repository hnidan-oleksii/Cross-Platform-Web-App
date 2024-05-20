package edu.chnu.ua.crossplatform.reading_now;

import edu.chnu.ua.crossplatform.books.BookValidationGroupSequence;
import edu.chnu.ua.crossplatform.books.CreateBookFormData;
import edu.chnu.ua.crossplatform.books.book.BookService;
import edu.chnu.ua.crossplatform.books.book.Genre;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value={"/", "/reading_now"})
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

    @GetMapping("/create")
    public String createBookForm(Model model) {
        model.addAttribute("book", new CreateBookFormData());
        model.addAttribute("genres", List.of(Genre.values()));
        return "books/edit";
    }

    @PostMapping("/create")
    public String createBook(@Validated(BookValidationGroupSequence.class)
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
}
