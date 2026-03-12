package com.AxylHM.commande_service.service;
import com.AxylHM.commande_service.dto.CommandeRequest;
import com.AxylHM.commande_service.dto.CommandeResponse;
import java.util.List;

public interface CommandeService {
    CommandeResponse creerCommande(CommandeRequest request);
    List<CommandeResponse> getAllCommandes();
}