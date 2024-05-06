package edu.chnu.ua.crossplatform.reading_now;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ReadingNowController {
    @GetMapping()
    public String readingNow(Model model) {
        model.addAttribute("pageTitle", "Reading Now");
        model.addAttribute("activeMenuItem", "reading-now");
        return "books/books";
    }
}
