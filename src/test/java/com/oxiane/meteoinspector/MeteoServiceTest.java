package com.oxiane.meteoinspector;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.openmeteo.client.OpenMeteoClient;

@SpringBootTest
public class MeteoServiceTest {

    @Mock
    private OpenMeteoClient openMeteoClient;

    @InjectMocks
    private MeteoService service;

    @Test
    public void testWeatherZeroIsGood(){
        when(openMeteoClient.getWeatherCode()).thenReturn("0");
        assertTrue(service.isWeatherNice());
    }

    @Test
    public void testWeather2IsGood(){
        when(openMeteoClient.getWeatherCode()).thenReturn("2");
        assertTrue(service.isWeatherNice());
    }

    @Test
    public void testWeather42IsBad(){
        when(openMeteoClient.getWeatherCode()).thenReturn("42");
        assertFalse(service.isWeatherNice());
    }

    @Test
    public void testWeather51IsBad(){
        when(openMeteoClient.getWeatherCode()).thenReturn("51");
        assertFalse(service.isWeatherNice());
    }


}
