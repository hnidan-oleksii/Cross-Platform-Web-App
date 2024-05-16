package edu.chnu.ua.crossplatform.reading_now;

import edu.chnu.ua.crossplatform.book.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
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
}
