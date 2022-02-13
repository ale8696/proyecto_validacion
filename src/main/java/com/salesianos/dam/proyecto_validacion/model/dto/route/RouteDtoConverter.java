package com.salesianos.dam.proyecto_validacion.model.dto.route;

import com.salesianos.dam.proyecto_validacion.model.Route;
import org.springframework.stereotype.Component;

@Component
public class RouteDtoConverter {

    public Route routeToRouteDto(RouteDto dto){
        return Route.builder()
                .name(dto.getName())
                .steps(dto.getSteps())
                .build();
    }

}
