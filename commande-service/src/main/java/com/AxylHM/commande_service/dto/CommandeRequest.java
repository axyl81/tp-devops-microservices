package com.AxylHM.commande_service.dto;
import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class CommandeRequest {
    private String description;
    private Double montant;
}