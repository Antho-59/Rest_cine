package org.example.exo2_cine.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo2_cine.dto.RealResponseDTO;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Realisateur {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private LocalDate birthdate;

    @OneToMany(mappedBy = "realisateur")
    private java.util.List<Film> films;

   public RealResponseDTO realToDto(){
       return RealResponseDTO.builder()
               .id(getId())
               .nom(getNom())
               .prenom(getPrenom())
               .birthdate(getBirthdate().toString())
               .build();
   }

//    public Object entityToDTO() {
//        return null;
//    }
}
