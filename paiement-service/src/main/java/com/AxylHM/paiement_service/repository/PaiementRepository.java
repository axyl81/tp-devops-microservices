package com.AxylHM.paiement_service.repository;

import com.AxylHM.paiement_service.domain.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}