package edu.chnu.ua.crossplatform.have_read;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/have_read")
public class HaveReadController {
    @GetMapping
    public String haveRead(Model model) {
        model.addAttribute("pageTitle", "Have Read");
        model.addAttribute("activeMenuItem", "have-read");
        return "books/books";
    }
}
