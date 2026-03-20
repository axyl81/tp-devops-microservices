package com.AxylHM.catalogue_service.service;

import com.AxylHM.catalogue_service.dto.ProduitResponse;
import java.util.List;

public interface CatalogueService {
    ProduitResponse getProduitById(Long id);
    List<ProduitResponse> getAllProduits();
}