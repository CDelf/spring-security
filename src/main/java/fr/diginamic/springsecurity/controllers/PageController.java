package fr.diginamic.springsecurity.controllers;

import fr.diginamic.springsecurity.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/register")
    public String createUserPage() {
        return "register";
    }

    @GetMapping("/add-article")
    public String addArticle() {
        return "add-article";
    }

    @GetMapping("/article/list")
    public String listArticles(Model model) {
        model.addAttribute("articles", articleRepository.findAll());
        return "article-list";
    }
}
