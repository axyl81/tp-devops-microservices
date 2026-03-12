package com.AxylHM.commande_service.controller;

import jakarta.validation.Valid; // Pour la validation
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// On importe les classes qui DOIVENT être dans le projet commande-service
// Si elles n'existent pas encore, il faudra les créer (voir étape suivante)
import com.AxylHM.commande_service.dto.CommandeRequest;
import com.AxylHM.commande_service.dto.CommandeResponse;
import com.AxylHM.commande_service.service.CommandeService;

@RestController
@RequestMapping("/api/v1/commandes")
@RequiredArgsConstructor
public class CommandeController {

    private final CommandeService commandeService;

    @PostMapping
    public ResponseEntity<CommandeResponse> creerCommande(@Valid @RequestBody CommandeRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commandeService.creerCommande(request));
    }

    @GetMapping
    public ResponseEntity<List<CommandeResponse>> getAllCommandes() {
        return ResponseEntity.ok(commandeService.getAllCommandes());
    }
}