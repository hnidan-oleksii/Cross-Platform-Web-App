package edu.chnu.ua.crossplatform.to_read;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/to-read")
public class ToReadController {
    @GetMapping
    public String trash(Model model) {
        model.addAttribute("pageTitle", "To Read");
        model.addAttribute("activeMenuItem", "to-read");
        return "books/books";
    }
}