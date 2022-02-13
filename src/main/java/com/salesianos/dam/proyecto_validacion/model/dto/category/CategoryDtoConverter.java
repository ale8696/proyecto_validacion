package com.salesianos.dam.proyecto_validacion.model.dto.category;

import com.salesianos.dam.proyecto_validacion.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoConverter {

    public Category categoryDtoToCategory(CategoryDto dto){
        return Category.builder()
                .name(dto.getName())
                .build();
    }

}
