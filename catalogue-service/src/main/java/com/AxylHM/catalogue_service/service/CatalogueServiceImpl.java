package com.AxylHM.catalogue_service.service;

import com.AxylHM.catalogue_service.domain.Produit;
import com.AxylHM.catalogue_service.dto.ProduitResponse;
import com.AxylHM.catalogue_service.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CatalogueServiceImpl implements CatalogueService {

    private final ProduitRepository produitRepository;

    @Override
    public ProduitResponse getProduitById(Long id) {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit introuvable avec l'ID : " + id));

        return ProduitResponse.builder()
                .id(produit.getId())
                .nom(produit.getNom())
                .prix(produit.getPrix())
                .stock(produit.getStock())
                .build();
    }

    @Override
    public List<ProduitResponse> getAllProduits() {
        return produitRepository.findAll().stream()
                .map(produit -> ProduitResponse.builder()
                        .id(produit.getId())
                        .nom(produit.getNom())
                        .prix(produit.getPrix())
                        .stock(produit.getStock())
                        .build())
                .collect(Collectors.toList());
    }
}