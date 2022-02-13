package com.salesianos.dam.proyecto_validacion.validation.anotation;

import com.salesianos.dam.proyecto_validacion.validation.validator.ValidUrlValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidUrlValidator.class)
public @interface ValidUrl {

    String message () default "{POI.url.valid}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String coverPhoto();

    String photo2();

    String photo3();
}
