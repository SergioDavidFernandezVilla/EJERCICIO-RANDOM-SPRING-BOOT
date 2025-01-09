package com.example.Practica.services;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.Practica.persistence.entity.MarcaEntity;
import com.example.Practica.persistence.repository.MarcaRepository;
import com.example.Practica.presentation.controller.dto.MarcaDTO;
import com.example.Practica.utils.mappers.MarcaMapper;

import jakarta.transaction.Transactional;

@Service
public class MarcaService {
    
    private final MarcaRepository marcaRepository;

    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    // CREATE
    public MarcaDTO createMarca(MarcaDTO marcaDTO) {
        MarcaEntity marca = MarcaMapper.INSTANCE.fromDTO(marcaDTO);

        if(marcaRepository.existsByNombre(marcaDTO.nombre())){
            throw new RuntimeException("La marca ya existe");
        }

        // NOMBRES VALIDOS REGEX
        if(marcaDTO.nombre() == null || !marcaDTO.nombre().matches("[a-zA-Z ]+")){
            throw new RuntimeException("El nombre de la marca no es valido");
        }

        // DESCRIPCION VALIDA REGEX
        if(marcaDTO.descripcion() == null || !marcaDTO.descripcion().matches("[a-zA-Z0-9 ]+")){
            throw new RuntimeException("La descripcion de la marca no es valida");
        }

        MarcaEntity marcaSaved = marcaRepository.save(marca);
        return MarcaMapper.INSTANCE.fromEntity(marcaSaved);
    }

    // GET BY ID
    public MarcaDTO findMarcaById(Long id) {
        return marcaRepository.findById(id)
                .map(MarcaMapper.INSTANCE::fromEntity)
                .orElseThrow(() -> new RuntimeException("La marca con id: " + id + " no existe"));
    }

    // GET ALL
    public List<MarcaDTO> findAllMarcas(){

        if(marcaRepository.count() == 0){
            throw new RuntimeException("No hay marcas");
        }

        return marcaRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))
        .stream()
        .map(MarcaMapper.INSTANCE::fromEntity)
        .toList();
    }

    // DELETE
    public void deleteMarca(Long id) {
        if(!marcaRepository.existsById(id)){
            throw new RuntimeException("La marca con id: " + id + " no existe");
        }
        marcaRepository.deleteById(id);
    }

    // UPDATE
    @Transactional
    public MarcaDTO updateMarca(Long id, MarcaDTO marcaDTO){
        return marcaRepository.findById(id)
                .map(marca -> {
                    marca.setNombre(marcaDTO.nombre());
                    marca.setDescripcion(marcaDTO.descripcion());
                    return marcaRepository.save(marca);
                })
                .map(MarcaMapper.INSTANCE::fromEntity)
                .orElseThrow(() -> new RuntimeException("La marca con id: " + id + " no existe"));
    }
}
