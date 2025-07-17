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


    private Product getProductFromRepo(int prodId){
        return repo.findById(prodId)
                .orElseThrow(() -> new ProductNotFoundException(prodId));
    }

    private void validateProductData(double price, int stock) {
        if (price <= 0 || stock <= 0) throw new InvalidProductDataException();
    }

    public ProductDTO getProduct(int prodId) {
        return getProductFromRepo(prodId).getDTO();
    }

    public List<ProductDTO> getProductList(){

        return repo.findAll().stream()
                .map(Product::getDTO)
                .toList();
    }

    public List<ProductDTO> findProduct(String name) {
        List<ProductDTO> l = repo.findByNombreContainingIgnoreCase(name).stream()
                .map(Product::getDTO)
                .toList();
        if (l.isEmpty()) throw new ProductNotFoundException(name);
        return l;
    }

    public ProductDTO addProduct(Product p) {
        validateProductData(p.getPrecio(), p.getStock());
        return repo.save(p).getDTO();
    }

    public String deleteProduct(int prodId) {
        Product p = getProductFromRepo(prodId);
        String name = p.getNombre();
        repo.delete(p);
        return ("Producto eliminado: " + name);

    }

    public ProductDTO editProduct(int prodId, double price, int stock, String imageUrl) {
        validateProductData(price, stock);
        Product p = getProductFromRepo(prodId);
        p.updateData(price, stock, imageUrl);
        return repo.save(p).getDTO();
    }
}
