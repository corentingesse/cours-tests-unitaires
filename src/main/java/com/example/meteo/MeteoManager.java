package com.example.meteo;

public class MeteoManager {
    private final WeatherService weatherService;

    public MeteoManager(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public String getWeatherDescription(String location) {
        String weather = weatherService.getCurrentWeather(location);
        return "Météo actuelle à " + location + ": " + weather;
    }
}