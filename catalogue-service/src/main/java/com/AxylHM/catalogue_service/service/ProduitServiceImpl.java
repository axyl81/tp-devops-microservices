package com.AxylHM.catalogue_service.service;

import com.AxylHM.catalogue_service.domain.Produit;
import com.AxylHM.catalogue_service.dto.ProduitRequest;
import com.AxylHM.catalogue_service.dto.ProduitResponse;
import com.AxylHM.catalogue_service.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j // Pour les logs structurés (demandés dans ton projet)
public class ProduitServiceImpl implements ProduitService {

    // Injection de dépendance via le constructeur (grâce à @RequiredArgsConstructor)
    private final ProduitRepository produitRepository;

    @Override
    public ProduitResponse creerProduit(ProduitRequest request) {
        log.info("Création d'un nouveau produit : {}", request.getNom());

        // 1. Mapping : Request DTO -> Entity
        Produit produit = Produit.builder()
                .nom(request.getNom())
                .description(request.getDescription())
                .prix(request.getPrix())
                .quantiteEnStock(request.getQuantiteEnStock())
                .build();

        // 2. Sauvegarde en base de données
        Produit savedProduit = produitRepository.save(produit);

        // 3. Mapping : Entity -> Response DTO
        return mapToResponse(savedProduit);
    }

    @Override
    public ProduitResponse getProduitById(Long id) {
        log.info("Recherche du produit avec l'ID : {}", id);

        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé avec l'ID : " + id));

        return mapToResponse(produit);
    }

    @Override
    public List<ProduitResponse> getAllProduits() {
        log.info("Récupération de tous les produits");

        return produitRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // Méthode utilitaire pour éviter de répéter le code de mapping
    private ProduitResponse mapToResponse(Produit produit) {
        return ProduitResponse.builder()
                .id(produit.getId())
                .nom(produit.getNom())
                .description(produit.getDescription())
                .prix(produit.getPrix())
                .quantiteEnStock(produit.getQuantiteEnStock())
                .build();
    }
}