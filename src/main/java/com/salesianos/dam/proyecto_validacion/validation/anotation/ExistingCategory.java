package com.salesianos.dam.proyecto_validacion.validation.anotation;

import com.salesianos.dam.proyecto_validacion.validation.validator.ExistingCategoryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistingCategoryValidator.class)
public @interface ExistingCategory {

    String message() default "{POI.category.existing}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
