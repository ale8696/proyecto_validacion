package com.salesianos.dam.proyecto_validacion.validation.validator;

import com.salesianos.dam.proyecto_validacion.repository.CategoryRepository;
import com.salesianos.dam.proyecto_validacion.validation.anotation.ExistingCategory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistingCategoryValidator implements ConstraintValidator<ExistingCategory, Long> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void initialize(ExistingCategory constraintAnnotation) {}

    @Override
    public boolean isValid(Long s, ConstraintValidatorContext constraintValidatorContext) {
        return s != null && categoryRepository.existsById(s);
    }

}
