package com.AxylHM.commande_service.service;
import com.AxylHM.commande_service.dto.CommandeRequest;
import com.AxylHM.commande_service.dto.CommandeResponse;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService {
    @Override
    public CommandeResponse creerCommande(CommandeRequest request) {
        // Logique simplifiée pour que ça compile
        return CommandeResponse.builder().id(1L).description(request.getDescription()).montant(request.getMontant()).build();
    }
    @Override
    public List<CommandeResponse> getAllCommandes() {
        return new ArrayList<>();
    }
}