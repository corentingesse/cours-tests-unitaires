package com.example.meteo;

public class SimulatedWeatherService implements WeatherService {
    @Override
    public String getCurrentWeather(String location) {
        // Simulation de données météo aléatoires
        String[] weatherTypes = {"Ensoleillé", "Nuageux", "Pluvieux", "Orageux", "Neigeux"};
        String[] temperatures = {"15°C", "20°C", "10°C", "25°C", "5°C"};
        
        int randomWeather = (int)(Math.random() * weatherTypes.length);
        int randomTemp = (int)(Math.random() * temperatures.length);
        
        return weatherTypes[randomWeather] + ", " + temperatures[randomTemp];
    }
}