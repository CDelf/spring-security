package fr.diginamic.springsecurity.controllers;

import fr.diginamic.springsecurity.models.Article;
import fr.diginamic.springsecurity.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    @PostMapping("/new")
    public String saveArticle(@ModelAttribute Article article) throws Exception {
        articleRepository.save(new Article(article.getTitre(), article.getContenu()));
        return "Article créé";
    }
}
