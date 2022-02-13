package com.salesianos.dam.proyecto_validacion.service;

import com.salesianos.dam.proyecto_validacion.error.exception.ListEntityNotFoundException;
import com.salesianos.dam.proyecto_validacion.error.exception.SingleEntityNotFoundException;
import com.salesianos.dam.proyecto_validacion.model.Category;
import com.salesianos.dam.proyecto_validacion.model.dto.category.CategoryDto;
import com.salesianos.dam.proyecto_validacion.model.dto.category.CategoryDtoConverter;
import com.salesianos.dam.proyecto_validacion.repository.CategoryRepository;
import com.salesianos.dam.proyecto_validacion.service.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService extends BaseService<Category, Long, CategoryRepository> {

    private final CategoryDtoConverter categoryDtoConverter;

    public Category get(Long id){
        return repository.findById(id).orElseThrow(()->
                new SingleEntityNotFoundException(id.toString(),Category.class));
    }

    public List<Category> getAll(){
        List<Category> list = repository.findAll();
        if(list.isEmpty()){
            throw new ListEntityNotFoundException(Category.class);
        }else
            return list;
    }

    public void remove(Long id){
        repository.findById(id).orElseThrow(()->
                new SingleEntityNotFoundException(id.toString(), Category.class));
        if(repository.findById(id).isPresent())
            repository.deleteById(id);
    }

    public Category post(CategoryDto categoryDto){
        return repository.save(categoryDtoConverter.categoryDtoToCategory(categoryDto));
    }

    public Category put(Long id, CategoryDto categoryDto){
        return repository.findById(id).map(c->{
            c.setName(categoryDto.getName());
            repository.save(c);
            return c;
        }).orElseThrow(()-> new SingleEntityNotFoundException(id.toString(), Category.class));
    }

}
