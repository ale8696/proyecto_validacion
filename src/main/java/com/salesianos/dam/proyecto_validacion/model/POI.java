package com.salesianos.dam.proyecto_validacion.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor @AllArgsConstructor @Builder
@Getter @Setter
public class POI {

    // Attributes
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String location;

    private String description;

    private LocalDateTime date;

    @ManyToOne
    private Category category;

    private String coverPhoto;

    private String photo2;

    private String photo3;

}
