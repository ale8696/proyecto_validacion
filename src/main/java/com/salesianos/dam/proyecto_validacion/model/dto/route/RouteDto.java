package com.salesianos.dam.proyecto_validacion.model.dto.route;

import com.salesianos.dam.proyecto_validacion.model.POI;
import com.salesianos.dam.proyecto_validacion.validation.anotation.UniqueRoute;
import lombok.*;

import java.util.List;

@AllArgsConstructor @NoArgsConstructor @Builder
@Getter @Setter
public class RouteDto {

    private Long id;

    @UniqueRoute(message = "{Route.name.unique}")
    private String name;

    private List<POI> steps;

}
