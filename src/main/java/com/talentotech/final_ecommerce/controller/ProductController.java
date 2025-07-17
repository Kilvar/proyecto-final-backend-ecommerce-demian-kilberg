package com.talentotech.final_ecommerce.controller;

import com.talentotech.final_ecommerce.dto.ProductDTO;
import com.talentotech.final_ecommerce.dto.response.ProductResponseDTO;
import com.talentotech.final_ecommerce.dto.response.ResponseDTO;
import com.talentotech.final_ecommerce.exception.InvalidProductDataException;
import com.talentotech.final_ecommerce.exception.ProductNotFoundException;
import com.talentotech.final_ecommerce.model.Product;
import com.talentotech.final_ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getProduct(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ProductResponseDTO("Producto encontrado", service.getProduct(id)));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseDTO(e.getMessage()));
        }

    }

    @GetMapping("/listAll")
    public ResponseEntity<List<ProductDTO>> listProducts() {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.getProductList());
    }

    @GetMapping("/find")
    public ResponseEntity<List<ProductDTO>> findProduct(@RequestParam String productName){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.findProduct(productName));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> editProduct(@PathVariable int id,
                                                   @RequestParam float price,
                                                   @RequestParam int stock,
                                                   @RequestParam String image_url){

        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ProductResponseDTO("Producto modificado", service.editProduct(id, price, stock, image_url)));
        } catch (ProductNotFoundException | InvalidProductDataException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO(e.getMessage()));
        }

    }

    @PostMapping("/")
    public ResponseEntity<ResponseDTO> addProduct(@RequestBody Product p) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ProductResponseDTO("Producto creado", service.addProduct(p)));
        } catch (InvalidProductDataException e){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body(new ResponseDTO(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteProduct(@PathVariable int id){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDTO(service.deleteProduct(id)));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseDTO(e.getMessage()));
        }
    }

}
