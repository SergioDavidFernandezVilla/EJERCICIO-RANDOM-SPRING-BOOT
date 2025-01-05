package com.example.Practica.utils.mappers;

import com.example.Practica.persistence.entity.ImageEntity;
import com.example.Practica.presentation.controller.dto.ImageDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-05T06:24:52+0000",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class ImageMapperImpl implements ImageMapper {

    @Override
    public ImageDTO fromEntity(ImageEntity image) {
        if ( image == null ) {
            return null;
        }

        Long id = null;
        String type = null;
        String fileName = null;
        String filePath = null;
        LocalDateTime updated_at = null;

        id = image.getId();
        type = image.getType();
        fileName = image.getFileName();
        filePath = image.getFilePath();
        updated_at = image.getUpdated_at();

        ImageDTO imageDTO = new ImageDTO( id, type, fileName, filePath, updated_at );

        return imageDTO;
    }

    @Override
    public ImageEntity fromDTO(ImageDTO image) {
        if ( image == null ) {
            return null;
        }

        ImageEntity.ImageEntityBuilder imageEntity = ImageEntity.builder();

        imageEntity.fileName( image.fileName() );
        imageEntity.filePath( image.filePath() );
        imageEntity.id( image.id() );
        imageEntity.type( image.type() );
        imageEntity.updated_at( image.updated_at() );

        return imageEntity.build();
    }

    @Override
    public List<ImageDTO> toImageDTOList(List<ImageEntity> images) {
        if ( images == null ) {
            return null;
        }

        List<ImageDTO> list = new ArrayList<ImageDTO>( images.size() );
        for ( ImageEntity imageEntity : images ) {
            list.add( fromEntity( imageEntity ) );
        }

        return list;
    }
}
