package com.oxiane.meteoinspector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.oxiane.meteoinspector","com.openmeteo.client"})
public class MeteoInspectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeteoInspectorApplication.class, args);
	}

}
