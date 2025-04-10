# Cours Tests Unitaires - Projet avec Prometheus

## Prérequis

1. Dézipez l'archive `prometheus-2.47.0.windows-amd64.zip` dans le dossier racine du projet

## Configuration

1. Le fichier `prometheus.yml` est déjà configuré pour surveiller l'application sur le port 1234
2. Aucune modification supplémentaire n'est nécessaire

## Lancement

1. Exécutez Prometheus en lançant `prometheus.exe` depuis le dossier dézippé
2. Lancez l'application Java avec `mvn exec:java`
3. Les métriques seront disponibles sur http://localhost:1234/metrics
4. L'interface Prometheus sera disponible sur http://localhost:9090

## Dépendances

Le projet utilise la bibliothèque Prometheus Java Client qui est déjà configurée dans le pom.xml