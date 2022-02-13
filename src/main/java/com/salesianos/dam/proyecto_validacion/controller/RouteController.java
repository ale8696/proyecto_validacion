package com.salesianos.dam.proyecto_validacion.controller;

import com.salesianos.dam.proyecto_validacion.model.Route;
import com.salesianos.dam.proyecto_validacion.model.dto.route.RouteDto;
import com.salesianos.dam.proyecto_validacion.service.POIService;
import com.salesianos.dam.proyecto_validacion.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/route")
public class RouteController {

    private final RouteService routeService;
    private final POIService poiService;

    @GetMapping("/")
    public List<Route> findAll(){
        return routeService.getAll();
    }

    @GetMapping("/{id}")
    public Route get(@PathVariable Long id){
        return routeService.get(id);
    }

    @PostMapping("/")
    public Route post(@Valid @RequestBody RouteDto routeDto){
        return routeService.post(routeDto);
    }

    @PutMapping("/{id}")
    public Route put(@PathVariable Long id, @Valid @RequestBody RouteDto routeDto){
        return routeService.put(id, routeDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        routeService.remove(id);
    }

    @PostMapping("/{id1}/poi/{id2}")
    public Route addPOIToRoute(@PathVariable Long id1, @PathVariable Long id2) {
        return routeService.addPOI(id1,id2);
    }

    @DeleteMapping("/{id1}/poi/{id2}")
    public void removePoiOfRoute(@PathVariable Long id1, @PathVariable Long id2){routeService.removePOI(id1, id2);}

}
