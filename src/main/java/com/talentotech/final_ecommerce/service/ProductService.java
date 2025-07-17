package com.talentotech.final_ecommerce.service;

import com.talentotech.final_ecommerce.dto.ProductDTO;
import com.talentotech.final_ecommerce.exception.InvalidProductDataException;
import com.talentotech.final_ecommerce.exception.ProductNotFoundException;
import com.talentotech.final_ecommerce.model.Category;
import com.talentotech.final_ecommerce.model.Product;
import com.talentotech.final_ecommerce.repository.CategoryRepo;
import com.talentotech.final_ecommerce.repository.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.PropertyValueException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ProductService {

    @Autowired
    ProductRepo prodRepo;

    @Autowired
    CategoryRepo catRepo;


    private Product getProductFromRepo(int prodId){
        return prodRepo.findById(prodId)
                .orElseThrow(() -> new ProductNotFoundException(prodId));
    }

    private double validatePrice(double price){
        if(price <= 0) throw new InvalidProductDataException("Precio debe ser mayor a 0");
        return price;
    }

    private int validateStock(int stock){
        if(stock <= 0) throw new InvalidProductDataException("Stock debe ser mayor a 0");
        return stock;
    }

    public ProductDTO getProduct(int prodId) {
        return getProductFromRepo(prodId).getDTO();
    }

    public List<ProductDTO> getProductList(){

        return prodRepo.findAll().stream()
                .map(Product::getDTO)
                .toList();
    }

    public List<ProductDTO> findProduct(String name) {
        List<ProductDTO> l = prodRepo.findByNombreContainingIgnoreCase(name).stream()
                .map(Product::getDTO)
                .toList();
        if (l.isEmpty()) throw new ProductNotFoundException(name);
        return l;
    }

    public ProductDTO addProduct(Product p) {

        validatePrice(p.getPrecio());
        validateStock(p.getStock());

        return prodRepo.save(p).getDTO();

    }

    public String deleteProduct(int prodId) {
        Product p = getProductFromRepo(prodId);
        String name = p.getNombre();
        prodRepo.delete(p);
        return ("Producto eliminado: " + name);

    }

    public ProductDTO editProduct(int prodId, Map<String, Object> updatedFields) {
        Product p = getProductFromRepo(prodId);
        try {
            updatedFields.forEach((key, value) -> {
                switch(key){
                    case("nombre"):
                        p.setNombre((String) value);
                        break;
                    case("descripcion"):
                        p.setDescripcion((String) value);
                        break;
                    case("precio"):
                        p.setPrecio(validatePrice((double) value));
                        break;
                    case("stock"):
                        p.setStock(validateStock((int) value));
                        break;
                    case("categoria_id"):
                        int id = (int) value;
                        Category c = catRepo.findById(id).orElseThrow(()-> new InvalidProductDataException(id));
                        p.setCategoria(c);
                        break;
                    case("url_imagen"):
                        p.setUrl_imagen((String) value);
                        break;
                    default:
                        throw new InvalidProductDataException(String.format(
                                "La propiedad %s no existe, o no es modificable", key
                        ));
                }
            });
        } catch (ClassCastException | NumberFormatException e) {
            throw new InvalidProductDataException("Verifique los datos de entrada");
        }

        return prodRepo.save(p).getDTO();
    }
}
