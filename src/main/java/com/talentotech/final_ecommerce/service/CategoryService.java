package com.talentotech.final_ecommerce.service;

import com.talentotech.final_ecommerce.exception.CategoryNotFoundException;
import com.talentotech.final_ecommerce.model.Category;
import com.talentotech.final_ecommerce.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo catRepo;

    public Category getCategoryById(Long id){
        return catRepo.findById(id)
                .orElseThrow(()-> new CategoryNotFoundException(String.format("El id %d es invalido", id))
                );
    }

    public Category getCategoryByName(String name){
        return catRepo.findBynombreCategoriaIgnoreCase(name)
                .orElseThrow(()-> new CategoryNotFoundException(String.format("El nombre %s es invalido", name)));
    }

    public Category addCategory(Category c){
        return catRepo.save(c);
    }

    public List<Category> getCategoryList(){
        return catRepo.findAll();
    }
}
