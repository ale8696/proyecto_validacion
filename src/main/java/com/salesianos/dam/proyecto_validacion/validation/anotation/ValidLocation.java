package com.salesianos.dam.proyecto_validacion.validation.anotation;

import com.salesianos.dam.proyecto_validacion.validation.validator.ValidLocationValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidLocationValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidLocation {

    String message() default "{POI.location.valid}";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

    String location();

}
