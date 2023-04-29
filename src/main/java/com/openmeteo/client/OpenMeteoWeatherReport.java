package com.openmeteo.client;

import java.util.List;

/**
 * Objet retourné en réponse par le site open-meteo.com
 * (Notez le package différent du reste de l'application)
 */
public class OpenMeteoWeatherReport {
    public double latitude;
    public double longitude;
    public double generationtime_ms;
    public int utc_offset_seconds;
    public String timezone;
    public String timezone_abbreviation;
    public double elevation;
    public DailyUnits daily_units;
    public Daily daily;

    public class Daily{
        public List<String> time;
        public List<String> weathercode;
    }
    
    public class DailyUnits{
        public String time;
        public String weathercode;
    }
    

}

