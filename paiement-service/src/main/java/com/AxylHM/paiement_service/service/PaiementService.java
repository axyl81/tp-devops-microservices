package com.AxylHM.paiement_service.service;

import com.AxylHM.paiement_service.dto.PaiementRequest;
import com.AxylHM.paiement_service.dto.PaiementResponse;

public interface PaiementService {
    PaiementResponse traiterPaiement(PaiementRequest request);
}