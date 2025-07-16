package com.talentotech.final_ecommerce.service;

import com.talentotech.final_ecommerce.dto.ProductDTO;
import com.talentotech.final_ecommerce.exception.InvalidProductDataException;
import com.talentotech.final_ecommerce.exception.ProductNotFoundException;
import com.talentotech.final_ecommerce.model.Product;
import com.talentotech.final_ecommerce.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    public List<ProductDTO> getProductList(){

        return repo.findAll().stream()
                .map(Product::getDTO)
                .toList();
    }

    public ProductDTO getProduct(int prodId) {
        Product p = repo.findById(prodId)
                .orElseThrow(() -> new ProductNotFoundException(prodId));
        return p.getDTO();
    }

    public ProductDTO addProduct(Product p) {
        if(p.getStock() <= 0 || p.getPrecio() <= 0) throw new InvalidProductDataException();
        else {
            repo.save(p);
            return p.getDTO();
        }
    }




}
