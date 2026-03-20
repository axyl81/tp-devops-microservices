package com.AxylHM.commande_service.service;

import com.AxylHM.commande_service.client.CatalogueServiceClient;
import com.AxylHM.commande_service.domain.Commande;
import com.AxylHM.commande_service.dto.CommandeRequest;
import com.AxylHM.commande_service.dto.CommandeResponse;
import com.AxylHM.commande_service.dto.ProduitResponse;
import com.AxylHM.commande_service.repository.CommandeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommandeServiceImpl implements CommandeService {

    private final CatalogueServiceClient catalogueServiceClient;
    private final CommandeRepository commandeRepository;

    @Override
    public CommandeResponse creerCommande(CommandeRequest request) {
        ProduitResponse produit = catalogueServiceClient.getProduitById(request.getProduitId());

        if (produit == null) {
            throw new RuntimeException("Erreur : Le produit avec l'ID " + request.getProduitId() + " n'existe pas !");
        }

        Commande commande = Commande.builder()
                .produitId(request.getProduitId())
                .quantite(request.getQuantite())
                .dateCommande(LocalDateTime.now())
                .build();

        Commande commandeSauvegardee = commandeRepository.save(commande);

        return CommandeResponse.builder()
                .id(commandeSauvegardee.getId())
                .produitId(commandeSauvegardee.getProduitId())
                .quantite(commandeSauvegardee.getQuantite())
                .build();
    }

    @Override
    public List<CommandeResponse> getAllCommandes() {
        return commandeRepository.findAll().stream()
                .map(commande -> CommandeResponse.builder()
                        .id(commande.getId())
                        .produitId(commande.getProduitId())
                        .quantite(commande.getQuantite())
                        .build())
                .collect(Collectors.toList());
    }
}