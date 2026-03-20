package com.AxylHM.paiement_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // OBLIGATOIRE pour qu'Eureka le trouve
public class PaiementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaiementServiceApplication.class, args);
	}
}