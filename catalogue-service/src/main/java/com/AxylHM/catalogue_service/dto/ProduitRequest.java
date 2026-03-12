
package com.AxylHM.catalogue_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProduitRequest {

    @NotBlank(message = "Le nom du produit est obligatoire")
    private String nom;

    private String description;

    @NotNull(message = "Le prix est obligatoire")
    @Positive(message = "Le prix doit être strictement positif")
    private Double prix;

    @NotNull(message = "La quantité est obligatoire")
    @PositiveOrZero(message = "La quantité ne peut pas être négative")
    private Integer quantiteEnStock;
}