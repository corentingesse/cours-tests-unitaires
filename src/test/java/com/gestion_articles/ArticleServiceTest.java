package com.gestion_articles;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import java.io.File;

public class ArticleServiceTest {
    private ArticleService articleService;
    private static final String JSON_FILE_PATH = "target/classes/articles.json";

    @Before
    public void setUp() {
        articleService = new ArticleService();
    }

    @After
    public void tearDown() {
        File file = new File(JSON_FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testAjouterArticle() {
        Article article = articleService.ajouterArticle("Article 1", 10.0);
        assertNotNull(article.getId());
        assertEquals("Article 1", article.getNom());
        assertEquals(10.0, article.getPrix(), 0.0);

        // Vérifier la persistance
        ArticleService newService = new ArticleService();
        Article persistedArticle = newService.recupererArticleParId(article.getId());
        assertNotNull(persistedArticle);
        assertEquals(article.getNom(), persistedArticle.getNom());
        assertEquals(article.getPrix(), persistedArticle.getPrix(), 0.0);
    }

    @Test
    public void testSupprimerArticle() {
        Article article = articleService.ajouterArticle("Article 1", 10.0);
        articleService.supprimerArticle(article.getId());
        assertNull(articleService.recupererArticleParId(article.getId()));

        // Vérifier la persistance de la suppression
        ArticleService newService = new ArticleService();
        assertNull(newService.recupererArticleParId(article.getId()));
    }

    @Test
    public void testRecupererTousLesArticles() {
        articleService.ajouterArticle("Article 1", 10.0);
        articleService.ajouterArticle("Article 2", 20.0);
        assertEquals(2, articleService.recupererTousLesArticles().size());

        // Vérifier la persistance
        ArticleService newService = new ArticleService();
        assertEquals(2, newService.recupererTousLesArticles().size());
    }
}