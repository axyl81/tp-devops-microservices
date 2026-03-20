package com.AxylHM.gateway_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

// 🎯 LES 3 IMPORTS MAGIQUES (C'est là qu'était le piège !)
import static org.springframework.web.servlet.function.RouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.uri;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	@Bean
	public RouterFunction<ServerResponse> catalogueRoute() {
		// La syntaxe absolue pour ta version de Gateway MVC :
		return route()
				// 1. On attrape la requête entrante (http() reste vide !)
				.GET("/api/v1/produits", http())
				.GET("/api/v1/produits/**", http())
				// 2. On indique la destination avec le filtre uri()
				.before(uri("http://catalogue-service:8081"))
				.build();
	}
}