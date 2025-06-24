package org.example.exo2_cine.repository;

import org.example.exo2_cine.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

      // - Récupérer les films par réalisateur
   @Query("SELECT f FROM Film f WHERE f.realisateur.id = :id")
    public List<Film> getFilmsByRealisateur(Long id);

}
