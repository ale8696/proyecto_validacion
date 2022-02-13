package com.salesianos.dam.proyecto_validacion.validation.anotation;

import com.salesianos.dam.proyecto_validacion.validation.validator.UniqueRouteValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueRouteValidator.class)
public @interface UniqueRoute {

    String message () default "{Route.name.unique}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
