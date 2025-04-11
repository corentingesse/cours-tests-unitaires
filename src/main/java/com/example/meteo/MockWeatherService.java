package com.example.meteo;

public class MockWeatherService implements WeatherService {
    @Override
    public String getCurrentWeather(String location) {
        // Simulation simple - retourne toujours "Ensoleillé" pour Paris
        if ("Paris".equalsIgnoreCase(location)) {
            return "Ensoleillé";
        } else if ("Lyon".equalsIgnoreCase(location)) {
            return "Conditions météo inconnues pour " + location;
        } else if ("Marseille".equalsIgnoreCase(location)) {
            return "Pluvieux";
        }
        return "Conditions météo inconnues pour " + location;
    }
}