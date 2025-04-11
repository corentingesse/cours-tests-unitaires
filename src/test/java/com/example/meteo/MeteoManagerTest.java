package com.example.meteo;

import static org.junit.Assert.*;

import org.junit.Test;

public class MeteoManagerTest {
    @Test
    public void testGetWeatherDescription() {
        // Création du mock
        WeatherService mockService = new MockWeatherService();
        MeteoManager manager = new MeteoManager(mockService);
        
        // Test avec Paris
        String result = manager.getWeatherDescription("Paris");
        assertEquals("Météo actuelle à Paris: Ensoleillé", result);
        
        // Test avec une autre ville
        result = manager.getWeatherDescription("Lyon");
        assertEquals("Météo actuelle à Lyon: Conditions météo inconnues pour Lyon", result);
    }
}