package com.salesianos.dam.proyecto_validacion.controller;

import com.salesianos.dam.proyecto_validacion.model.POI;
import com.salesianos.dam.proyecto_validacion.model.dto.poi.POIDto;
import com.salesianos.dam.proyecto_validacion.service.POIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poi")
public class POIController {

    private final POIService poiService;

    @GetMapping("/")
    public List<POI> getAll(){
        return poiService.getAll();
    }

    @GetMapping("/{id}")
    public POI get(@PathVariable Long id){
        return poiService.get(id);
    }

    @PostMapping("/")
    public POI post(@Valid @RequestBody POIDto poiDto){
        return poiService.post(poiDto);
    }

    @PutMapping("/{id}")
    public POI put(@PathVariable Long id, @Valid @RequestBody POIDto poiDto){
        return poiService.put(id, poiDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        poiService.remove(id);
    }

}
