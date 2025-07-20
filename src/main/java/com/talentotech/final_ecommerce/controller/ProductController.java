package com.talentotech.final_ecommerce.controller;

import com.talentotech.final_ecommerce.dto.ProductDTO;
import com.talentotech.final_ecommerce.model.Product;
import com.talentotech.final_ecommerce.response.ResponseHandler;
import com.talentotech.final_ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable int id) {
        return ResponseHandler.buildResponse("Producto encontrado con exito",
                HttpStatus.OK, service.getProduct(id));
    }

    @GetMapping("/list/all")
    public ResponseEntity<List<ProductDTO>> listProducts() {
            return ResponseHandler.buildResponse("Lista de productos registrados obtenida con exito",
                    HttpStatus.OK,
                    service.getProductList());
    }

    @GetMapping("/list/{categoryName}")
    public ResponseEntity<List<ProductDTO>> listProductsByCategory(@PathVariable String categoryName){
        return ResponseHandler.buildResponse("Lista de productos registrados por categoria obtenida con exito",
            HttpStatus.OK,
            service.getProductListByCategory(categoryName));
    }

    @GetMapping("/find")
    public ResponseEntity<List<ProductDTO>> findProduct(@RequestParam String productName){
        return ResponseHandler.buildResponse("Productos encontrados con exito",
                HttpStatus.OK,
                service.findProduct(productName));
    }


    @PatchMapping("/{id}")
    public ResponseEntity<ProductDTO> editProduct(@PathVariable int id,
                                              @RequestBody Map<String, Object> updatedFields){
        return ResponseHandler.buildResponse("Producto editado con exito",
                HttpStatus.OK,
                service.editProduct(id, updatedFields));

    }

    @PostMapping("/")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody Product p) {
        return ResponseHandler.buildResponse("Producto creado con exito",
                HttpStatus.CREATED,
                service.addProduct(p));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        return ResponseHandler.buildResponse("Producto eliminado con exito",
                HttpStatus.OK,
                service.deleteProduct(id));
    }

}
