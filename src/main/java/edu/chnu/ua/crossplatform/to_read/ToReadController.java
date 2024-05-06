package edu.chnu.ua.crossplatform.to_read;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/to_read")
public class ToReadController {
    @GetMapping
    public String trash(Model model) {
        model.addAttribute("pageTitle", "To Read");
        return "books/books";
    }
}