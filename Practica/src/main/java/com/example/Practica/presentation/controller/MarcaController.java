package com.example.Practica.presentation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Practica.presentation.controller.dto.MarcaDTO;
import com.example.Practica.services.MarcaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/marca")
public class MarcaController {
    
    private MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    //GET ALL
    @GetMapping("/all")
    public ResponseEntity<List<MarcaDTO>> findAllMarcas(){
        return ResponseEntity.ok(marcaService.findAllMarcas());
    }

    //CREATE
    @PostMapping
    public ResponseEntity<MarcaDTO> CreateMarca(@Valid @RequestBody MarcaDTO marcaDTO){
        return new ResponseEntity<>(marcaService.createMarca(marcaDTO), HttpStatus.CREATED);
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<MarcaDTO> updateMarca(@PathVariable Long id, @Valid @RequestBody MarcaDTO marcaDTO){
        MarcaDTO responseDTO = marcaService.updateMarca(id, marcaDTO);
        return ResponseEntity.ok(responseDTO);
    }
    

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarca(@PathVariable Long id){
        marcaService.deleteMarca(id);
        return ResponseEntity.noContent().build();
    }

    //BYID
    @GetMapping("/{id}")
    public ResponseEntity<MarcaDTO> findMarcaById(@PathVariable Long id){
        MarcaDTO marcaDTO = marcaService.findMarcaById(id);
        return ResponseEntity.ok(marcaDTO);
    }
        
}
