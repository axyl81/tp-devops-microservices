package com.AxylHM.paiement_service.controller;

import com.AxylHM.paiement_service.dto.PaiementRequest;
import com.AxylHM.paiement_service.dto.PaiementResponse;
import com.AxylHM.paiement_service.service.PaiementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/paiements")
@RequiredArgsConstructor
public class PaiementController {

    private final PaiementService paiementService;

    @PostMapping
    public ResponseEntity<PaiementResponse> effectuerPaiement(@RequestBody PaiementRequest request) {
        return ResponseEntity.ok(paiementService.traiterPaiement(request));
    }
}