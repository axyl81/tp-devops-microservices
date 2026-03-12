
package com.AxylHM.commande_service.controller;

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
@RequestMapping("/api/v1/commandes")
@RequiredArgsConstructor
public class CommandeController {

    // Note : Assure-toi d'avoir créé CommandeService et les DTOs (Request/Response)
    private final CommandeService commandeService;

    @PostMapping
    public ResponseEntity<CommandeResponse> creerCommande(@RequestBody CommandeRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commandeService.creerCommande(request));
    }

    @GetMapping
    public ResponseEntity<List<CommandeResponse>> getAllCommandes() {
        return ResponseEntity.ok(commandeService.getAllCommandes());
    }
}