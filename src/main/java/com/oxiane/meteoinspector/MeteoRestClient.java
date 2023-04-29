package com.oxiane.meteoinspector;

/**
 * Interface pour abstraire un client REST vers un service capable
 * de fournir un code WMO pour le temps actuel.
 */
public interface MeteoRestClient {
    public String getWeatherCode();
}
