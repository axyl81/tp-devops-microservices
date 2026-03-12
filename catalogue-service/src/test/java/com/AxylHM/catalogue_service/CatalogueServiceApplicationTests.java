package com.AxylHM.catalogue_service;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test") // C'est ici que ça doit être !
class CatalogueServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}