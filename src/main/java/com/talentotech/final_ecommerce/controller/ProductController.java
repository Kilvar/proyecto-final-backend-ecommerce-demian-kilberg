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
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {
        return ResponseHandler.buildResponse("Producto encontrado con exito",
                HttpStatus.OK, service.getProductById(id).getDTO());
    }

    @GetMapping("/list/all")
    public ResponseEntity<List<ProductDTO>> listProducts() {

        List<ProductDTO> pList = service.getProductList().stream()
                .map(Product::getDTO).toList();

            return ResponseHandler.buildResponse("Lista de productos registrados obtenida con exito",
                    HttpStatus.OK,
                    pList);
    }

    @GetMapping("/list/{categoryName}")
    public ResponseEntity<List<ProductDTO>> listProductsByCategory(@PathVariable String categoryName){

        List<ProductDTO> pList = service.getProductListByCategory(categoryName).stream()
                .map(Product::getDTO).toList();

        return ResponseHandler.buildResponse("Lista de productos registrados por categoria obtenida con exito",
            HttpStatus.OK,
            pList);
    }

    @GetMapping("/find")
    public ResponseEntity<List<ProductDTO>> findProduct(@RequestParam String productName){

        List<ProductDTO> pList = service.getProductByName(productName).stream()
                .map(Product::getDTO).toList();

        return ResponseHandler.buildResponse("Productos encontrados con exito",
                HttpStatus.OK,
                pList);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<ProductDTO> editProduct(@PathVariable Long id,
                                              @RequestBody Map<String, Object> updatedFields){
        return ResponseHandler.buildResponse("Producto editado con exito",
                HttpStatus.OK,
                service.editProduct(id, updatedFields).getDTO());
    }

    @PostMapping("/")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody Product p) {
        return ResponseHandler.buildResponse("Producto creado con exito",
                HttpStatus.CREATED,
                service.addProduct(p).getDTO());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        return ResponseHandler.buildResponse("Producto eliminado con exito",
                HttpStatus.OK,
                service.deleteProduct(id));
    }

}
