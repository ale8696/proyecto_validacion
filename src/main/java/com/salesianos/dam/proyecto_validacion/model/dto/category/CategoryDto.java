package com.salesianos.dam.proyecto_validacion.model.dto.category;

import com.salesianos.dam.proyecto_validacion.validation.anotation.UniqueCategory;
import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Builder
@Getter @Setter
public class CategoryDto {

    @UniqueCategory
    private String name;

}
