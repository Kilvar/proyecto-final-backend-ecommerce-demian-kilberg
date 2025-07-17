package com.talentotech.final_ecommerce.controller;

import com.talentotech.final_ecommerce.dto.ProductDTO;
import com.talentotech.final_ecommerce.exception.InvalidProductDataException;
import com.talentotech.final_ecommerce.exception.ProductNotFoundException;
import com.talentotech.final_ecommerce.model.Product;
import com.talentotech.final_ecommerce.response.ResponseHandler;
import com.talentotech.final_ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.lang.Object;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable int id) {
        return ResponseHandler.buildResponse("Producto encontrado con exito",
                HttpStatus.OK, service.getProduct(id));
    }

    @GetMapping("/listAll")
    public ResponseEntity<Object> listProducts() {
            return ResponseHandler.buildResponse("Lista de productos registrados obtenida con exito",
                    HttpStatus.OK,
                    service.getProductList());
    }

    @GetMapping("/find")
    public ResponseEntity<Object> findProduct(@RequestParam String productName){
        System.out.println(productName);
        return ResponseHandler.buildResponse("Productos encontrados con exito",
                HttpStatus.OK,
                service.findProduct(productName));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> editProduct(@PathVariable int id,
                                              @RequestBody Map<String, Object> updatedFields){
        return ResponseHandler.buildResponse("Producto editado con exito",
                HttpStatus.OK,
                service.editProduct(id, updatedFields));

    }

    @PostMapping("/")
    public ResponseEntity<Object> addProduct(@RequestBody Product p) {
        return ResponseHandler.buildResponse("Producto creado con exito",
                HttpStatus.CREATED,
                service.addProduct(p));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable int id){
        return ResponseHandler.buildResponse("Producto eliminado con exito",
                HttpStatus.OK,
                service.deleteProduct(id));
    }

}
