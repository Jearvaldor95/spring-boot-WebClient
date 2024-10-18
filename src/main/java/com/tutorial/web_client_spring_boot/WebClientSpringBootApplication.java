package com.tutorial.web_client_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class WebClientSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebClientSpringBootApplication.class, args);
	}

}
