package org.example.exo2_cine.service;


import org.example.exo2_cine.dto.RealDTO;
import org.example.exo2_cine.dto.RealResponseDTO;
import org.example.exo2_cine.entity.Realisateur;
import org.example.exo2_cine.exception.NotFoundException;
import org.example.exo2_cine.repository.RealRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealService {

    private RealRepository realRepository;
    public RealService(RealRepository realRepository) {
        this.realRepository = realRepository;
    }

    // CRUD

    // create

    public RealResponseDTO createReal(RealDTO realDTO){
        return realRepository.save(realDTO.dtoToEntity()).realToDto();
    }

    // read
    public RealResponseDTO getReal(Long id){
        return realRepository.findById(id).orElseThrow(NotFoundException::new).realToDto();
    }

    public List<RealResponseDTO> getAllReal(){
        return realRepository.findAll().stream().map(Realisateur::realToDto).toList();
    }

    // update
    public RealResponseDTO updateReal(Long id, RealDTO realDTO){
        Realisateur realFound = realRepository.findById(id).orElseThrow(NotFoundException::new);
        Realisateur realGet = realDTO.dtoToEntity();
        realFound.setNom(realGet.getNom());
        realFound.setPrenom(realGet.getPrenom());
        realFound.setBirthdate(realGet.getBirthdate());
        realFound.setFilms(realGet.getFilms());

        return realRepository.save(realFound).realToDto();
    }

    // delete
    public void deleteReal(Long id){
        realRepository.deleteById(id);
    }



}
