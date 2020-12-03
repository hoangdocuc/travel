package com.hoangdocuc.travel.converter;

import com.hoangdocuc.travel.dto.PlaceDTO;
import com.hoangdocuc.travel.entity.PlaceEntity;
import org.springframework.stereotype.Component;

@Component
public class PlaceConverter {

    public PlaceEntity toEntity(PlaceDTO placeDTO){
        PlaceEntity placeEntity = new PlaceEntity();
        placeEntity.setName(placeDTO.getName());
        placeEntity.setTitle(placeDTO.getTitle());
        placeEntity.setContent(placeDTO.getContent());
        placeEntity.setImage(placeDTO.getImage());
        placeEntity.setViews(placeDTO.getViews());
        return  placeEntity;
    }

    public PlaceEntity toEntity(PlaceDTO placeDTO,PlaceEntity placeEntity){
        placeEntity.setName(placeDTO.getName());
        placeEntity.setTitle(placeDTO.getTitle());
        placeEntity.setContent(placeDTO.getContent());
        placeEntity.setImage(placeDTO.getImage());
        placeEntity.setViews(placeDTO.getViews());
        return  placeEntity;
    }

    public PlaceDTO toDTO(PlaceEntity placeEntity){
        PlaceDTO placeDTO = new PlaceDTO();
        placeDTO.setId(placeEntity.getId());
        placeDTO.setTitle(placeEntity.getTitle());
        placeDTO.setContent(placeEntity.getContent());
        placeDTO.setName(placeEntity.getName());
        placeDTO.setImage(placeEntity.getImage());
        placeDTO.setViews(placeEntity.getViews());
        return placeDTO;
    }



}
