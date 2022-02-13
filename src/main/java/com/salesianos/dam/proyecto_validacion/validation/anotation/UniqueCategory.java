package com.salesianos.dam.proyecto_validacion.validation.anotation;

import com.salesianos.dam.proyecto_validacion.validation.validator.UniqueCategoryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueCategoryValidator.class)
public @interface UniqueCategory {

    String message () default "{Category.name.unique}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
