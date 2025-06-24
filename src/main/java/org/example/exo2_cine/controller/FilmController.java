package org.example.exo2_cine.controller;


import org.example.exo2_cine.dto.FilmDTO;
import org.example.exo2_cine.dto.FilmResponseDTO;
import org.example.exo2_cine.dto.RealDTO;
import org.example.exo2_cine.dto.RealResponseDTO;
import org.example.exo2_cine.service.FilmService;
import org.example.exo2_cine.service.RealService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {


    private FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    // CRud
    // create
    @PostMapping
    public ResponseEntity<FilmResponseDTO> createFilm(@RequestBody FilmDTO filmDTO){
        return ResponseEntity.ok(filmService.createFilm(filmDTO));
    }


    // read
    @GetMapping("/{id}")
    public ResponseEntity<FilmResponseDTO> getReal(@PathVariable Long id){
        return ResponseEntity.ok(filmService.getFilm(id));
    }
    @GetMapping
    public ResponseEntity<List<FilmResponseDTO>> getAllReal(){
        return ResponseEntity.ok(filmService.getAllFilm());
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<FilmResponseDTO> updateFilm(@PathVariable long id, @RequestBody FilmDTO filmDTO){
        return ResponseEntity.ok(filmService.updateFilm(id, filmDTO));
    }
    // delete
    @DeleteMapping("/{id}")
    public void deleteFilm(@PathVariable Long id){
        filmService.deleteFilm(id);
    }

//    - Récupérer les films par réalisateur
  @GetMapping("/realisateurs/{id}")
    public List<FilmResponseDTO> getFilmsByRealisateur(@PathVariable Long id) {
        return filmService.getFilmsByRealisateur(id);
    }


}
