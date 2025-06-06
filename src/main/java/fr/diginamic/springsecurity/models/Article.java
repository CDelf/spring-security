package fr.diginamic.springsecurity.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String titre;

    private String contenu;

    public Article(String titre, String contenu) {
        this.titre = titre;
        this.contenu = contenu;
    }
}
