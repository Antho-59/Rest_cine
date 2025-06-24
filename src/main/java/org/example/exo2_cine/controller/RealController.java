package org.example.exo2_cine.controller;


import org.example.exo2_cine.dto.RealDTO;
import org.example.exo2_cine.dto.RealResponseDTO;
import org.example.exo2_cine.service.RealService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/realisateurs")
public class RealController {

    private RealService realService;

    public RealController(RealService realService) {
        this.realService = realService;
    }

    // CRud
    // create
    @PostMapping
    public ResponseEntity<RealResponseDTO> createReal(@RequestBody RealResponseDTO realDTO){
        return ResponseEntity.ok(realService.createReal(realDTO));
    }


    // read
    @GetMapping("/{id}")
    public ResponseEntity<RealResponseDTO> getReal(@PathVariable Long id){
        return ResponseEntity.ok(realService.getReal(id));
    }
    @GetMapping
    public ResponseEntity<List<RealResponseDTO>> getAllReal(){
        return ResponseEntity.ok(realService.getAllReal());
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<RealResponseDTO> updateReal(@PathVariable long id, @RequestBody RealDTO realDTO){
        return ResponseEntity.ok(realService.updateReal(id, realDTO));
    }
    // delete
    @DeleteMapping("/{id}")
    public void deleteReal(@PathVariable Long id){
        realService.deleteReal(id);
    }


}
