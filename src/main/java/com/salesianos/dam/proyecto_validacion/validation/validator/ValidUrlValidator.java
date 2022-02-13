package com.salesianos.dam.proyecto_validacion.validation.validator;

import com.salesianos.dam.proyecto_validacion.validation.anotation.ValidUrl;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidUrlValidator implements ConstraintValidator<ValidUrl, Object> {

    private String photoCover;
    private String photo2;
    private String photo3;

    @Override
    public void initialize(ValidUrl constraintAnnotation) {
        this.photoCover = constraintAnnotation.coverPhoto();
        this.photo2 = constraintAnnotation.photo2();
        this.photo3 = constraintAnnotation.photo3();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String photoCoverValue = (String) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(photoCover);
        String photo2Value = (String) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(photo2);
        String photo3Value = (String) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(photo3);

        if(photoCoverValue == null)
            return true;

        if(photoCoverValue.equals(photo2Value) || photoCoverValue.equals(photo3Value) || photo2Value.equals(photo3Value)){
            return false;
        }else return true;
    }

}
