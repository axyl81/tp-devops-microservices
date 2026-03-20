package com.AxylHM.paiement_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaiementRequest {
    private Long commandeId;
    private Double montant;
}