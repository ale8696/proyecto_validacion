package com.salesianos.dam.proyecto_validacion.repository;

import com.salesianos.dam.proyecto_validacion.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {

    boolean existsByName(String name);

}
