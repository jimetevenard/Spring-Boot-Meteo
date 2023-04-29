package com.openmeteo.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.oxiane.meteoinspector.MeteoRestClient;

/**
 * Client Meteo pour le site open-meteo.com
 * (Notez le package différent du reste de l'application)
 * 
 * Pour rapidité (démo improvisée en formation)) la
 * géolocalisation est codée en dur
 * 
 * (il s'agit de Saint-Mandé, à coté de Paris)
 */
@Service
public class OpenMeteoClient implements MeteoRestClient {

    private final RestTemplate restTemplate;

    private final static String URL_PATH = "/v1/forecast?latitude=48.84&longitude=2.42&daily=weathercode&forecast_days=1&timezone=Europe/Berlin";

    public OpenMeteoClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.rootUri("https://api.open-meteo.com").build();
    }

    @Override
    public String getWeatherCode(){
        OpenMeteoWeatherReport report = restTemplate.getForObject(URL_PATH, OpenMeteoWeatherReport.class);
        return report.daily.weathercode.get(0);
    }
    
}
