
package com.AxylHM.catalogue_service.controller;

import com.AxylHM.catalogue_service.dto.ProduitRequest;
import com.AxylHM.catalogue_service.dto.ProduitResponse;
import com.AxylHM.catalogue_service.service.ProduitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produits") // Bonne pratique : API versionnée
@RequiredArgsConstructor
@Slf4j
public class ProduitController {

    private final ProduitService produitService;

    @PostMapping
    public ResponseEntity<ProduitResponse> creerProduit(@Valid @RequestBody ProduitRequest request) {
        log.info("Requête REST reçue pour créer un produit");
        ProduitResponse response = produitService.creerProduit(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProduitResponse> getProduitById(@PathVariable Long id) {
        log.info("Requête REST reçue pour récupérer le produit ID : {}", id);
        ProduitResponse response = produitService.getProduitById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ProduitResponse>> getAllProduits() {
        log.info("Requête REST reçue pour récupérer tous les produits");
        List<ProduitResponse> responses = produitService.getAllProduits();
        return ResponseEntity.ok(responses);
    }
}