package com.gestion_articles;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;

public class ArticleService {
    private List<Article> articles;
    private Long nextId;
    private static final String JSON_FILE_PATH = "target/classes/articles.json";
    private final ObjectMapper objectMapper;
    
    // Métriques Prometheus
    private static final Counter articlesAdded = Counter.build()
        .name("articles_added_total")
        .help("Nombre total d'articles ajoutés")
        .register();
        
    private static final Counter articlesDeleted = Counter.build()
        .name("articles_deleted_total")
        .help("Nombre total d'articles supprimés")
        .register();
        
    private static final Gauge articlesCount = Gauge.build()
        .name("articles_count")
        .help("Nombre actuel d'articles")
        .register();

    public ArticleService() {
        this.articles = new ArrayList<>();
        this.nextId = 1L;
        this.objectMapper = new ObjectMapper();
        chargerArticles();
    }

    private void chargerArticles() {
        try {
            File file = new File(JSON_FILE_PATH);
            if (file.exists()) {
                articles = objectMapper.readValue(file, new TypeReference<List<Article>>() {});
                nextId = articles.stream()
                        .mapToLong(Article::getId)
                        .max()
                        .orElse(0L) + 1L;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sauvegarderArticles() {
        try {
            objectMapper.writeValue(new File(JSON_FILE_PATH), articles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Article ajouterArticle(String nom, double prix) {
        Article article = new Article(nom, prix);
        article.setId(nextId++);
        articles.add(article);
        sauvegarderArticles();
        articlesAdded.inc();
        articlesCount.set(articles.size());
        return article;
    }

    public boolean supprimerArticle(Long id) {
        boolean removed = articles.removeIf(article -> article.getId().equals(id));
        if (removed) {
            sauvegarderArticles();
            articlesDeleted.inc();
            articlesCount.set(articles.size());
        }
        
        return removed;
    }

    public List<Article> recupererTousLesArticles() {
        return new ArrayList<>(articles);
    }

    public Article recupererArticleParId(Long id) {
        chargerArticles();
        return articles.stream()
                .filter(article -> article.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}