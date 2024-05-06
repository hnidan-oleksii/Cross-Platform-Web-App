package edu.chnu.ua.crossplatform.trash;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trash")
public class TrashController {
    @GetMapping
    public String trash(Model model) {
        model.addAttribute("pageTitle", "Trash");
        return "books/books";
    }
}
