package com.AxylHM.commande_service.client;

import com.AxylHM.commande_service.dto.ProduitResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "catalogue-service")
public interface CatalogueServiceClient {

    @GetMapping("/api/v1/produits/{id}")
    ProduitResponse getProduitById(@PathVariable("id") Long id);
}