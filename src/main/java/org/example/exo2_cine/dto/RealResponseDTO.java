package org.example.exo2_cine.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RealResponseDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String birthdate;
}
