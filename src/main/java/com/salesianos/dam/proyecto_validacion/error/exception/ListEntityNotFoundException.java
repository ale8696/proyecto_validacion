package com.salesianos.dam.proyecto_validacion.error.exception;

public class ListEntityNotFoundException extends EntityNotFoundException{

    public ListEntityNotFoundException(Class clazz) {
        super(String.format("No se pueden encontrar elementos del tipo %s ", clazz.getName()));
    }

}
