package com.salesianos.dam.proyecto_validacion.validation.validator;

import com.salesianos.dam.proyecto_validacion.repository.POIRepository;
import com.salesianos.dam.proyecto_validacion.validation.anotation.ValidLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidLocationValidator implements ConstraintValidator<ValidLocation, String> {

    private String location;

    @Autowired
    private POIRepository poiRepository;

    @Override
    public void initialize(ValidLocation constraintAnnotation) {location = constraintAnnotation.location();}

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.hasText(value) && !poiRepository.existsByLocation(value);
    }

}
