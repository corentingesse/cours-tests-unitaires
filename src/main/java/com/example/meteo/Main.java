package com.example.meteo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WeatherService weatherService = new SimulatedWeatherService();
        MeteoManager meteoManager = new MeteoManager(weatherService);
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Choisissez une option :");
        System.out.println("1. Saisir une ville manuellement");
        System.out.println("2. Sélectionner parmi les villes prédéfinies");
        System.out.print("Votre choix : ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // consommer le retour à la ligne
        
        String location;
        if (choice == 1) {
            System.out.print("Entrez une localisation : ");
            location = scanner.nextLine();
        } else {
            System.out.println("Villes disponibles :");
            System.out.println("1. Paris");
            System.out.println("2. Lyon");
            System.out.println("3. Marseille");
            System.out.print("Choisissez une ville : ");
            int cityChoice = scanner.nextInt();
            scanner.nextLine(); // consommer le retour à la ligne
            
            switch(cityChoice) {
                case 1: location = "Paris"; break;
                case 2: location = "Lyon"; break;
                case 3: location = "Marseille"; break;
                default: location = "Inconnu";
            }
        }
        
        String weatherDescription = meteoManager.getWeatherDescription(location);
        System.out.println(weatherDescription);
    }
}