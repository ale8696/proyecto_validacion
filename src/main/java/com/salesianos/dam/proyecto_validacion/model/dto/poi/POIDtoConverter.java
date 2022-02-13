package com.salesianos.dam.proyecto_validacion.model.dto.poi;

import com.salesianos.dam.proyecto_validacion.model.POI;
import com.salesianos.dam.proyecto_validacion.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class POIDtoConverter {

    @Autowired
    private CategoryService categoryService;

    public POI poiDtoToPoi(POIDto poiDto){
        return POI.builder()
                .name(poiDto.getName())
                .location(poiDto.getLocation())
                .description(poiDto.getDescription())
                .date(poiDto.getDate())
                .category(categoryService.get(poiDto.getCategory()))
                .coverPhoto(poiDto.getCoverPhoto())
                .photo2(poiDto.getPhoto2())
                .photo3(poiDto.getPhoto3())
                .build();
    }

}
