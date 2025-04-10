package com.gestion_articles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Application principale
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> articles = new ArrayList<>();
        
        while (true) {
            System.out.println("\nGestion des articles - Menu:");
            System.out.println("1. Ajouter un article");
            System.out.println("2. Supprimer un article");
            System.out.println("3. Lister les articles");
            System.out.println("4. Quitter");
            System.out.print("Choix : ");
            
            int choix = scanner.nextInt();
            scanner.nextLine(); // consommer le retour à la ligne
            
            switch (choix) {
                case 1:
                    System.out.print("Nom de l'article à ajouter : ");
                    String nouvelArticle = scanner.nextLine();
                    articles.add(nouvelArticle);
                    System.out.println("Article ajouté avec succès!");
                    break;
                case 2:
                    System.out.print("Index de l'article à supprimer : ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < articles.size()) {
                        articles.remove(index);
                        System.out.println("Article supprimé avec succès!");
                    } else {
                        System.out.println("Index invalide!");
                    }
                    break;
                case 3:
                    System.out.println("\nListe des articles:");
                    for (int i = 0; i < articles.size(); i++) {
                        System.out.println(i + ". " + articles.get(i));
                    }
                    break;
                case 4:
                    System.out.println("Au revoir!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Choix invalide!");
            }
        }
    }
}