package com.example.Practica.services;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.Practica.persistence.entity.MarcaEntity;
import com.example.Practica.persistence.repository.MarcaRepository;
import com.example.Practica.presentation.controller.dto.MarcaDTO;
import com.example.Practica.utils.mappers.MarcaMapper;

@Service
public class MarcaService {
    
    private final MarcaRepository marcaRepository;

    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    // CREATE
    public MarcaDTO createMarca(MarcaDTO marcaDTO) {
        MarcaEntity marca = MarcaMapper.INSTANCE.fromDTO(marcaDTO);
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
        return marcaRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))
        .stream()
        .map(MarcaMapper.INSTANCE::fromEntity)
        .toList();
    }

    // DELETE
    public void deleteMarca(Long id) {
        MarcaEntity marca = marcaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La marca con id: " + id + " no existe"));
        marcaRepository.delete(marca);
    }

    // UPDATE
    public MarcaDTO updateMarca(MarcaDTO marcaDTO){
        MarcaEntity marca = MarcaMapper.INSTANCE.fromDTO(marcaDTO);

        if(!marcaRepository.findById(marcaDTO.id()).isPresent()){
            throw new RuntimeException("La marca no existe");
        }

        if(marcaRepository.existsByNombre(marcaDTO.nombre())){
            throw new RuntimeException("La marca ya existe");
        }

        MarcaEntity marcaUpdated = marcaRepository.save(marca);
        return MarcaMapper.INSTANCE.fromEntity(marcaUpdated);
    }
}
