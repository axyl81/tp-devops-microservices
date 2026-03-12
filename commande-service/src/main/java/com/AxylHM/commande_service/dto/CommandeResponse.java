package com.AxylHM.commande_service.dto;
import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class CommandeResponse {
    private Long id;
    private String description;
    private Double montant;
}