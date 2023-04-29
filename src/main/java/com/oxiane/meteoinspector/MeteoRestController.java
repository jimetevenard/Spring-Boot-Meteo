package com.oxiane.meteoinspector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Contrôleur du endpoint REST exposé par notre application.
 * Retourne une chaine sur le temps, en fonction du retour du service.
 */
@RestController
public class MeteoRestController {

    @Autowired
    private MeteoService meteoService;

    @GetMapping("/")
    public String getMeteo(){
        if(meteoService.isWeatherNice()){
            return "Il fait beau !";
        } else {
            return "Le temps est mauvais !";
        }

    }
    
}
