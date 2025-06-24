package org.example.exo2_cine.service;


import org.example.exo2_cine.dto.FilmDTO;
import org.example.exo2_cine.dto.FilmResponseDTO;
import org.example.exo2_cine.entity.Film;
import org.example.exo2_cine.exception.NotFoundException;
import org.example.exo2_cine.repository.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    private FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }
    // CRUD

    // create
    public FilmResponseDTO createFilm(FilmDTO filmDTO){
        return filmRepository.save(filmDTO.dtoToEntity()).filmToDto();
    }

    // read
    public FilmResponseDTO getFilm(Long id){
        return filmRepository.findById(id).orElseThrow(NotFoundException::new).filmToDto();
    }

    public List<FilmResponseDTO> getAllFilm(){
        return filmRepository.findAll().stream().map(Film::filmToDto).toList();
    }

    // update
    public FilmResponseDTO updateFilm(Long id, FilmDTO filmDTO){
        Film filmFound = filmRepository.findById(id).orElseThrow(NotFoundException::new);
        Film filmGet = filmDTO.dtoToEntity();
        filmFound.setNom(filmGet.getNom());
        filmFound.setGenre(filmGet.getGenre());
        filmFound.setDescription(filmGet.getDescription());
        filmFound.setTempsFilm(filmGet.getTempsFilm());
        filmFound.setDateSortie(filmGet.getDateSortie());

        return filmRepository.save(filmFound).filmToDto();
    }

    // delete
    public void deleteFilm(Long id){
        filmRepository.deleteById(id);
    }

    public List<FilmResponseDTO> getFilmsByRealisateur(Long id) {
        return filmRepository.findByRealisateurId(id).stream().map(Film::filmToDto).toList();
    }
}
