package org.example.exo2_cine.repository;

import org.example.exo2_cine.entity.Realisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealRepository extends JpaRepository<Realisateur, Long> {

}
