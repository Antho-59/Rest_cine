package org.example.exo2_cine.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo2_cine.dto.FilmResponseDTO;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Film {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private LocalDate dateSortie;
    private String genre;
    private String description;
    private String tempsFilm;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "realisateur_id")
    private Realisateur realisateur;

    public FilmResponseDTO filmToDto(){
        return FilmResponseDTO.builder()
                .id(getId())
                .nom(getNom())
                .genre(getGenre())
                .description(getDescription())
                .tempsFilm(getTempsFilm())
                .dateSortie(getDateSortie())
                .build();
    }

}
