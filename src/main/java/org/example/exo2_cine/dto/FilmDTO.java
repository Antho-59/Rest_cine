package org.example.exo2_cine.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo2_cine.entity.Film;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FilmDTO {

    private Long id;
    private String nom;
    private String dateSortie;
    private String genre;
    private String description;
    private String tempsFilm;

    public Film dtoToEntity (){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return Film.builder()
                .id(id)
                .nom(nom)
                .genre(genre)
                .description(description)
                .tempsFilm(tempsFilm)
                .dateSortie(LocalDate.parse(dateSortie,formatter))
                .build();
    }

//    public Film dtoToEntity (){
//        return Film.builder()
//                .id(id)
//                .nom(nom)
//                .genre(genre)
//                .description(description)
//                .tempsFilm(tempsFilm)
//                .dateSortie(LocalDate.parse(dateSortie))  // marche pas
//                .build();
//    }
}
