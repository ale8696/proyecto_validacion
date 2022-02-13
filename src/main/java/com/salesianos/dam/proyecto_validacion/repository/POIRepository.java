package com.salesianos.dam.proyecto_validacion.repository;

import com.salesianos.dam.proyecto_validacion.model.POI;
import org.springframework.data.jpa.repository.JpaRepository;

public interface POIRepository extends JpaRepository<POI, Long> {

    boolean existsByLocation(String location);

}
