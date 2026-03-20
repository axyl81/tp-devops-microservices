package com.AxylHM.catalogue_service.controller;

import com.AxylHM.catalogue_service.dto.ProduitResponse;
import com.AxylHM.catalogue_service.service.CatalogueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produits") // L'URL magique attendue par ton FeignClient
@RequiredArgsConstructor
public class ProduitController {

    private final CatalogueService catalogueService;

    @GetMapping("/{id}")
    public ResponseEntity<ProduitResponse> getProduitById(@PathVariable Long id) {
        return ResponseEntity.ok(catalogueService.getProduitById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProduitResponse>> getAllProduits() {
        return ResponseEntity.ok(catalogueService.getAllProduits());
    }
}