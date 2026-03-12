package com.AxylHM.catalogue_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProduitResponse {

    private Long id;
    private String nom;
    private String description;
    private Double prix;
    private Integer quantiteEnStock;

}