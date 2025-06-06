package fr.diginamic.springsecurity.repositories;

import fr.diginamic.springsecurity.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
