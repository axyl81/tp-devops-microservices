package com.AxylHM.paiement_service.service;

import com.AxylHM.paiement_service.domain.Paiement;
import com.AxylHM.paiement_service.dto.PaiementRequest;
import com.AxylHM.paiement_service.dto.PaiementResponse;
import com.AxylHM.paiement_service.repository.PaiementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements PaiementService {

    private final PaiementRepository paiementRepository;

    @Override
    public PaiementResponse traiterPaiement(PaiementRequest request) {
        // Logique simulée : Si le montant est positif, on valide le paiement
        String statutPaiement = (request.getMontant() != null && request.getMontant() > 0) ? "VALIDÉ" : "REFUSÉ";

        Paiement paiement = Paiement.builder()
                .commandeId(request.getCommandeId())
                .montant(request.getMontant())
                .statut(statutPaiement)
                .datePaiement(LocalDateTime.now())
                .build();

        Paiement savedPaiement = paiementRepository.save(paiement);

        return PaiementResponse.builder()
                .id(savedPaiement.getId())
                .commandeId(savedPaiement.getCommandeId())
                .statut(savedPaiement.getStatut())
                .build();
    }
}