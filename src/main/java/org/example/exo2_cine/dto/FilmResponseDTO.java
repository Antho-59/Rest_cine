package org.example.exo2_cine.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class FilmResponseDTO {
    private Long id;
    private String nom;
    private LocalDate dateSortie;
    private String genre;
    private String description;
    private String tempsFilm;
}
