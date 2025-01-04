package com.example.Practica.utils.mappers;

import com.example.Practica.persistence.entity.ImageEntity;
import com.example.Practica.presentation.controller.dto.ImageDTO;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-04T04:03:03+0000",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
public class ImageMapperImpl implements ImageMapper {

    @Override
    public ImageEntity toEntity(ImageDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ImageEntity.ImageEntityBuilder imageEntity = ImageEntity.builder();

        imageEntity.fileName( dto.fileName() );
        imageEntity.filePath( dto.filePath() );
        imageEntity.id( dto.id() );
        imageEntity.type( dto.type() );

        return imageEntity.build();
    }

    @Override
    public ImageDTO toDTO(ImageEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String type = null;
        String fileName = null;
        String filePath = null;

        id = entity.getId();
        type = entity.getType();
        fileName = entity.getFileName();
        filePath = entity.getFilePath();

        LocalDateTime uploadedA = null;

        ImageDTO imageDTO = new ImageDTO( id, type, fileName, filePath, uploadedA );

        return imageDTO;
    }
}
