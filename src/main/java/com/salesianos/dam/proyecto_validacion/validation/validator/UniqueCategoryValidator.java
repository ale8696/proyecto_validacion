package com.salesianos.dam.proyecto_validacion.validation.validator;

import com.salesianos.dam.proyecto_validacion.repository.CategoryRepository;
import com.salesianos.dam.proyecto_validacion.validation.anotation.UniqueCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCategoryValidator implements ConstraintValidator<UniqueCategory, String> {

    @Autowired
    private CategoryRepository repository;

    @Override
    public void initialize(UniqueCategory constraintAnnotation) {
    }

    @Override
    public boolean isValid(String categoria, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(categoria) && !repository.existsByName(categoria);
    }

}
