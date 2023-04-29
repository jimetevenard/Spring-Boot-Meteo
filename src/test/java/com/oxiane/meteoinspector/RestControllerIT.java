package com.oxiane.meteoinspector;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class RestControllerIT {

    @MockBean
    private MeteoService meteoService;

    @Autowired
	private MockMvc mockMvc;

    @Test
    public void shouldReturnNiceWeather() throws Exception {
        when(meteoService.isWeatherNice()).thenReturn(true);
        mockMvc.perform(get("/")).andExpect(content().string("Il fait beau !"));
    }

    @Test
    public void shouldReturnBadWeather() throws Exception {
        when(meteoService.isWeatherNice()).thenReturn(false);
        mockMvc.perform(get("/")).andExpect(content().string("Le temps est mauvais !"));
    }
    
}
