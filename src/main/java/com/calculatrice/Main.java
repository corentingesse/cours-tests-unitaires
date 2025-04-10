package com.calculatrice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculatrice calc = new Calculatrice();
        boolean continuer = true;

        System.out.println("Bienvenue dans la calculatrice!");

        while (continuer) {
            System.out.println("\nChoisissez une opération :");
            System.out.println("1. Addition");
            System.out.println("2. Soustraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Quitter");

            try {
                int choix = scanner.nextInt();
                if (choix == 5) {
                    continuer = false;
                    System.out.println("Au revoir!");
                    continue;
                }

                if (choix < 1 || choix > 4) {
                    System.out.println("Choix invalide. Veuillez choisir entre 1 et 5.");
                    continue;
                }

                System.out.println("Entrez le premier nombre :");
                double a = scanner.nextDouble();
                System.out.println("Entrez le deuxième nombre :");
                double b = scanner.nextDouble();

                double resultat = 0;
                String operation = "";

                switch (choix) {
                    case 1:
                        resultat = calc.addition(a, b);
                        operation = "addition";
                        break;
                    case 2:
                        resultat = calc.soustraction(a, b);
                        operation = "soustraction";
                        break;
                    case 3:
                        resultat = calc.multiplication(a, b);
                        operation = "multiplication";
                        break;
                    case 4:
                        resultat = calc.division(a, b);
                        operation = "division";
                        break;
                }

                System.out.printf("Le résultat de la %s est : %.2f%n", operation, resultat);

            } catch (IllegalArgumentException e) {
                System.out.println("Erreur : " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erreur de saisie. Veuillez entrer des nombres valides.");
                scanner.nextLine(); // Vider le buffer
            }
        }
        scanner.close();
    }
}