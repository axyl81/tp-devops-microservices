package com.AxylHM.commande_service.repository;

import com.AxylHM.commande_service.domain.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
}