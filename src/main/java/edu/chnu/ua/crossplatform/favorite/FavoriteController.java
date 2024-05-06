package edu.chnu.ua.crossplatform.favorite;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/favorite")
public class FavoriteController {
    @GetMapping
    public String favorite(Model model) {
        model.addAttribute("pageTitle", "Favorite");
        model.addAttribute("activeMenuItem", "favorite");
        return "books/books";
    }
}
