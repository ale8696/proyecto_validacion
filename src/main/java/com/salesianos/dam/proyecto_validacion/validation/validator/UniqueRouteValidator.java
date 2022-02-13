package com.salesianos.dam.proyecto_validacion.validation.validator;

import com.salesianos.dam.proyecto_validacion.repository.RouteRepository;
import com.salesianos.dam.proyecto_validacion.validation.anotation.UniqueRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueRouteValidator implements ConstraintValidator<UniqueRoute, String> {

    @Autowired
    private RouteRepository repository;

    @Override
    public void initialize(UniqueRoute constraintAnnotation) {
    }

    @Override
    public boolean isValid(String route, ConstraintValidatorContext constraintValidatorContext) {
        if(repository == null){
            return true;
        }
        return StringUtils.hasText(route) && !repository.existsByName(route);
    }

}
