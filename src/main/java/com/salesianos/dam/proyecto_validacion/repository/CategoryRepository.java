package com.salesianos.dam.proyecto_validacion.repository;

import com.salesianos.dam.proyecto_validacion.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

        boolean existsByName(String name);

}
