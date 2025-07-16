package com.talentotech.final_ecommerce.controller;

import com.talentotech.final_ecommerce.dto.ProductDTO;
import com.talentotech.final_ecommerce.exception.InvalidProductDataException;
import com.talentotech.final_ecommerce.exception.ProductNotFoundException;
import com.talentotech.final_ecommerce.model.Product;
import com.talentotech.final_ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.getProduct(id));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    @PostMapping("/")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody Product p) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.addProduct(p));
        } catch (InvalidProductDataException e){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
        }
    }

}
