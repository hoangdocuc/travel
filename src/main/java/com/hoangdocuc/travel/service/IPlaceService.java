package com.hoangdocuc.travel.service;


import com.hoangdocuc.travel.dto.PlaceDTO;

import java.util.List;

public interface IPlaceService {
    List<PlaceDTO> findAll();
    void save(PlaceDTO placeDTO);
}
