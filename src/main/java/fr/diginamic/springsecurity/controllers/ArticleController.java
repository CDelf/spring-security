package fr.diginamic.springsecurity.controllers;

import fr.diginamic.springsecurity.models.Article;
import fr.diginamic.springsecurity.models.UserApp;
import fr.diginamic.springsecurity.repositories.ArticleRepository;
import fr.diginamic.springsecurity.repositories.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    UserAppRepository userAppRepository;

    @PostMapping("/new")
    public String saveArticle(@ModelAttribute Article article, Authentication authentication) throws Exception {
        String email = ((UserDetails) authentication.getPrincipal()).getUsername();
        UserApp auteur = userAppRepository.findByEmail(email).orElseThrow();

        article.setAuteur(auteur);
        articleRepository.save(article);

        return "Article créé";
    }
}
