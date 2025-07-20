package com.talentotech.final_ecommerce.controller;

import com.talentotech.final_ecommerce.dto.CategoryDTO;
import com.talentotech.final_ecommerce.model.Category;
import com.talentotech.final_ecommerce.response.ResponseHandler;
import com.talentotech.final_ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    @Autowired
    CategoryService service;

    @GetMapping("/list")
    public ResponseEntity<List<CategoryDTO>> listAllCategories(){

        List<CategoryDTO> cList = service.getCategoryList().stream()
                .map(Category::getDTO).toList();

        return ResponseHandler.buildResponse("Categorias obtenidas con exito",
                HttpStatus.OK,
                cList);
    }

    @PostMapping("/")
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody Category category) {
        return ResponseHandler.buildResponse("Categoria creada con exito",
                HttpStatus.CREATED,
                service.addCategory(category).getDTO());

    }
}
