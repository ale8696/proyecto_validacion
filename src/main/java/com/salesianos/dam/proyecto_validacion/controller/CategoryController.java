package com.salesianos.dam.proyecto_validacion.controller;

import com.salesianos.dam.proyecto_validacion.model.Category;
import com.salesianos.dam.proyecto_validacion.model.dto.category.CategoryDto;
import com.salesianos.dam.proyecto_validacion.service.CategoryService;
import com.salesianos.dam.proyecto_validacion.service.POIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;
    private final POIService poiService;

    @GetMapping("/{id}")
    public Category get(@PathVariable Long id){
        return categoryService.get(id);
    }

    @GetMapping("/")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @PostMapping("/")
    public Category post(@Valid @RequestBody CategoryDto categoryDto){
        return categoryService.post(categoryDto);
    }

    @PutMapping("/{id}")
    public Category put(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Long id){
        return categoryService.put(id, categoryDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        poiService.findAll().forEach(p->{
            if(p.getCategory().equals(categoryService.get(id))){
                p.setCategory(null);
                poiService.save(p);
            }
        });
        categoryService.remove(id);
    }

}
