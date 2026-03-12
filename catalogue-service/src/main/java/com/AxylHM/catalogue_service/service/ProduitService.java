package com.AxylHM.catalogue_service.service;

import com.AxylHM.catalogue_service.dto.ProduitRequest;
import com.AxylHM.catalogue_service.dto.ProduitResponse;
import java.util.List;

public interface ProduitService {
    ProduitResponse creerProduit(ProduitRequest request);
    ProduitResponse getProduitById(Long id);
    List<ProduitResponse> getAllProduits();
}