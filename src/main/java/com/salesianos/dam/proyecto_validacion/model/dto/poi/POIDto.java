package com.salesianos.dam.proyecto_validacion.model.dto.poi;

import com.salesianos.dam.proyecto_validacion.validation.anotation.ExistingCategory;
import com.salesianos.dam.proyecto_validacion.validation.anotation.ValidLocation;
import com.salesianos.dam.proyecto_validacion.validation.anotation.ValidUrl;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@AllArgsConstructor @NoArgsConstructor @Builder
@Getter @Setter
@ValidUrl(coverPhoto = "coverPhoto", photo2 = "photo2", photo3 = "photo3", message = "{POI.url.valid}")
public class POIDto {

    @NotBlank(message = "{POI.name.blank}")
    private String name;

    @NotBlank(message = "{POI.location.blank}")
    @ValidLocation(location = "location")
    @Pattern(
            regexp = "^(\\-?\\d+(\\.\\d+)?),\\w*(\\-?\\d+(\\.\\d+)?)$",
            message = "{POI.location.valid}"
    )
    private String location;

    @Lob
    private String description;

    @Past
    private LocalDateTime date;

    @ExistingCategory
    @NotNull(message = "{POI.category.blank}")
    private Long category;

    @URL
    @NotBlank(message = "{POI.url.blank}")
    private String coverPhoto;

    @URL
    private String photo2;

    @URL
    private String photo3;

}
