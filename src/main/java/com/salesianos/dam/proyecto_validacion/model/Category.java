package com.salesianos.dam.proyecto_validacion.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor @NoArgsConstructor @Builder
@Getter @Setter
public class Category {

    // Attributes
    @Id
    @GeneratedValue
    private Long id;

    private String name;

}
