package com.salesianos.dam.proyecto_validacion.service;

import com.salesianos.dam.proyecto_validacion.error.exception.ListEntityNotFoundException;
import com.salesianos.dam.proyecto_validacion.error.exception.POIRouteException;
import com.salesianos.dam.proyecto_validacion.error.exception.SingleEntityNotFoundException;
import com.salesianos.dam.proyecto_validacion.model.POI;
import com.salesianos.dam.proyecto_validacion.model.Route;
import com.salesianos.dam.proyecto_validacion.model.dto.route.RouteDto;
import com.salesianos.dam.proyecto_validacion.model.dto.route.RouteDtoConverter;
import com.salesianos.dam.proyecto_validacion.repository.RouteRepository;
import com.salesianos.dam.proyecto_validacion.service.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteService extends BaseService<Route, Long, RouteRepository> {

    private final RouteDtoConverter routeDtoConverter;
    private final POIService poiService;

    public List<Route> getAll(){
        List<Route> list = repository.findAll();
        if(list.isEmpty()){
            throw new ListEntityNotFoundException(Route.class);
        }else
            return list;
    }

    public Route get(Long id){
        return repository.findById(id).orElseThrow(()->
                new SingleEntityNotFoundException(id.toString(),Route.class));
    }

    public Route post(RouteDto routeDto){
        return repository.save(routeDtoConverter.routeToRouteDto(routeDto));
    }

    public Route put(Long id, RouteDto dto){
        return repository.findById(id).map(r->{
                    r.setName(dto.getName());
                    r.setSteps(dto.getSteps());
                    repository.save(r);
                    return r;
                })
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Route.class));
    }

    public void remove(Long id){

        repository.findById(id)
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Route.class));

        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
        }
    }

    public Route addPOI(Long id1, Long id2){
        Route route = repository.getById(id1);

        route.getSteps().forEach(p->{if(p.getId().equals(id2)){
            throw new POIRouteException(id2.toString(), POI.class);
        }});
        route.addPOI(poiService.get(id2));
        return repository.save(route);
    }

    public void removePOI(Long id1, Long id2) {
        Route route = repository.getById(id1);

        if(route == null)
            throw new SingleEntityNotFoundException(id1.toString(), Route.class);

        if (poiService.get(id2) != null) {
            route.removePOI(poiService.get(id2));
        }
    }

}
