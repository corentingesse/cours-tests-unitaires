package com.gestion_articles;

public class Article {
    private Long id;
    private String nom;
    private double prix;

    public Article() {
        // Constructeur par défaut nécessaire pour Jackson
    }

    public Article(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}