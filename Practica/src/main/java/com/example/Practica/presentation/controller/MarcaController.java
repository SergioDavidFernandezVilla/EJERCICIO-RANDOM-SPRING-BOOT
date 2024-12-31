package com.example.Practica.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Practica.persistence.entity.MarcaEntity;
import com.example.Practica.persistence.repository.MarcaRepository;
import com.example.Practica.presentation.controller.dto.MarcaDTO;
import com.example.Practica.utils.mappers.MarcaMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/marca")
public class MarcaController {
    
    private MarcaRepository marcaRepository;

    public MarcaController(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    //CREATE
    @PostMapping
    public ResponseEntity<MarcaDTO> createMarca(@Valid @RequestBody MarcaDTO marcaDTO){
        MarcaEntity marca = MarcaMapper.INSTANCE.fromDTO(marcaDTO);
        MarcaEntity marcaSaved = marcaRepository.save(marca);
        MarcaDTO responseDTO = MarcaMapper.INSTANCE.fromEntity(marcaSaved);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    //UPDATE

    //DELETE

    //BYID
    @GetMapping("/{id}")
    public ResponseEntity<MarcaDTO> findMarcaById(@RequestParam Long id){
        // BUSCAR EL ID SI EXISTE O NO
        if (marcaRepository.existsById(id)) {
            MarcaEntity marca = marcaRepository.findById(id).get();
            MarcaDTO responseDTO = MarcaMapper.INSTANCE.fromEntity(marca);
            return ResponseEntity.ok(responseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
        
    }
        
}
