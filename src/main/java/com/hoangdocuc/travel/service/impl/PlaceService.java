package com.hoangdocuc.travel.service.impl;

import com.hoangdocuc.travel.converter.PlaceConverter;
import com.hoangdocuc.travel.dto.PlaceDTO;
import com.hoangdocuc.travel.entity.PlaceEntity;
import com.hoangdocuc.travel.repository.PlaceRepository;
import com.hoangdocuc.travel.service.IPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceService implements IPlaceService {

    @Autowired
    private PlaceConverter placeConverter;

    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public List<PlaceDTO> findAll() {
        List<PlaceDTO> placeDTOList = new ArrayList<>();
        List<PlaceEntity> placeEntityList = placeRepository.findAll();
        for (PlaceEntity placeEntity : placeEntityList) {
            placeDTOList.add(placeConverter.toDTO(placeEntity));
        }
        return placeDTOList;
    }
}
