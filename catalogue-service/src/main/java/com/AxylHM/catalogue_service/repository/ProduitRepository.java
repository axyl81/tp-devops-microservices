package com.AxylHM.catalogue_service.repository;

import com.AxylHM.catalogue_service.domain.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
}