package com.oxiane.meteoinspector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service métier, porte les règles de gestions :
 * détermine s'il fait beau on non, à partir d'un code WMO standard.
 */
@Service
public class MeteoService {

    @Autowired
    private MeteoRestClient meteoClient;

    /**
     * Lis le code météo (WMO Weather) et retourne true si le temps est agréable,
     * false si le temps est mauvais.
     * 
     * https://www.open-meteo.com/en/docs
     */
    public boolean isWeatherNice(){
        return Integer.parseInt(meteoClient.getWeatherCode()) < 4;
    }
    
}
