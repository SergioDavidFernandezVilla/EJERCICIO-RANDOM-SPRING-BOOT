package com.example.Practica.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    //GET ALL
    public ResponseEntity<Object> findAllMarcas(){
        return ResponseEntity.status(HttpStatus.OK).body(marcaRepository.findAll());
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
    public ResponseEntity<MarcaDTO> updateMarca(@PathVariable Long id, @Valid @RequestBody MarcaDTO marcaDTO){
        return marcaRepository.findById(id)
            .map(marca -> {
                marca.setMarca(marcaDTO.marca());
                marca.setDescripcion(marcaDTO.descripcion());
                MarcaEntity marcaUpdated = marcaRepository.save(marca);
                MarcaDTO responseDTO = MarcaMapper.INSTANCE.fromEntity(marcaUpdated);
                return ResponseEntity.ok(responseDTO);
            })
            .orElse(ResponseEntity.notFound().build());
    }
    

    //DELETE
    public ResponseEntity<Void> deleteMarca(@PathVariable Long id){
        marcaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //BYID
    @GetMapping("/{id}")
    public ResponseEntity<MarcaDTO> findMarcaById(@PathVariable Long id){
        return marcaRepository.findById(id)
            .map(marca -> {
                MarcaDTO responseDTO = MarcaMapper.INSTANCE.fromEntity(marca);
                return ResponseEntity.ok(responseDTO);
            })
            .orElse(ResponseEntity.notFound().build());
        }
        
}
