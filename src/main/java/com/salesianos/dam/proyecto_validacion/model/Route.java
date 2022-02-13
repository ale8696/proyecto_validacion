package com.salesianos.dam.proyecto_validacion.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Builder
@Getter @Setter
public class Route {

    // Attributes
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany
    private List<POI> steps;

    //Helpers
    public void addPOI(POI poi){this.steps.add(poi);}

    public void removePOI(POI poi){this.steps.remove(poi);}

}
