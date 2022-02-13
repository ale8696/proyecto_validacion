package com.salesianos.dam.proyecto_validacion.service;

import com.salesianos.dam.proyecto_validacion.error.exception.ListEntityNotFoundException;
import com.salesianos.dam.proyecto_validacion.error.exception.SingleEntityNotFoundException;
import com.salesianos.dam.proyecto_validacion.model.POI;
import com.salesianos.dam.proyecto_validacion.model.dto.poi.POIDto;
import com.salesianos.dam.proyecto_validacion.model.dto.poi.POIDtoConverter;
import com.salesianos.dam.proyecto_validacion.repository.POIRepository;
import com.salesianos.dam.proyecto_validacion.service.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class POIService extends BaseService <POI, Long, POIRepository> {

    private final POIDtoConverter poiDtoConverter;
    private final CategoryService categoryService;

    public List<POI> getAll() {

        List<POI> list = repository.findAll();

        if(list.isEmpty()){
            throw new ListEntityNotFoundException(POI.class);
        }else
            return list;
    }

    public POI get(Long id){
        return repository.findById(id).orElseThrow(()->
                new SingleEntityNotFoundException(id.toString(),POI.class));
    }

    public POI put(Long id, POIDto dto){
        return repository.findById(id).map(p->{
                    p.setName(dto.getName());
                    p.setLocation(dto.getLocation());
                    p.setDescription(dto.getDescription());
                    p.setDate(dto.getDate());
                    p.setCategory(categoryService.get(dto.getCategory()));
                    p.setCoverPhoto(dto.getCoverPhoto());
                    p.setPhoto2(dto.getPhoto2());
                    p.setPhoto3(dto.getPhoto3());
                    repository.save(p);
                    return p;
                })
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), POI.class));
    }

    public POI post(POIDto poidto){return repository.save(poiDtoConverter.poiDtoToPoi(poidto));}

    public void remove(Long id){

        repository.findById(id)
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), POI.class));

        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
        }
    }

}
