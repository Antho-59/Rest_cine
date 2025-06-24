package org.example.exo2_cine.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo2_cine.entity.Realisateur;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RealDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String birthdate;

    public Realisateur dtoToEntity (){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return Realisateur.builder()
                .id(id)
                .nom(nom)
                .prenom(prenom)
                .birthdate(LocalDate.parse(birthdate,formatter))
                .build();
    }


}
