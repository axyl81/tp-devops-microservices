package com.AxylHM.paiement_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaiementResponse {
    private Long id;
    private Long commandeId;
    private String statut;
}