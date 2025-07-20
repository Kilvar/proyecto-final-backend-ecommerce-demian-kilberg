package com.talentotech.final_ecommerce.service;

import com.talentotech.final_ecommerce.exception.InvalidProductDataException;
import com.talentotech.final_ecommerce.exception.ProductNotFoundException;
import com.talentotech.final_ecommerce.model.Category;
import com.talentotech.final_ecommerce.model.Product;
import com.talentotech.final_ecommerce.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    ProductRepo prodRepo;

    @Autowired
    CategoryService catServ;


    private Product getProductFromRepo(Long prodId){
        return prodRepo.findById(prodId)
                .orElseThrow(() -> new ProductNotFoundException(prodId));
    }

    private BigDecimal validatePrice(double price){
        if(price <= 0) throw new InvalidProductDataException("Precio debe ser mayor a 0");
        return BigDecimal.valueOf(price);
    }

    private int validateStock(int stock){
        if(stock <= 0) throw new InvalidProductDataException("Stock debe ser mayor a 0");
        return stock;
    }

    public Product getProductById(Long prodId) {
        return getProductFromRepo(prodId);
    }

    public List<Product> getProductList(){
        return prodRepo.findAll();
    }

    public List<Product> getProductListByCategory(String name){
        Category c = catServ.getCategoryByName(name);
        return prodRepo.findByCategoria(c);
    }

    public List<Product> getProductByName(String name) {
        return prodRepo.findByNombreContainingIgnoreCase(name)
                .orElseThrow(()-> new ProductNotFoundException(name));
    }

    public Product addProduct(Product p) {

        validatePrice(p.getPrecio().doubleValue());
        validateStock(p.getStock());

        return prodRepo.save(p);

    }

    public String deleteProduct(Long prodId) {
        Product p = getProductFromRepo(prodId);
        String name = p.getNombre();
        prodRepo.delete(p);
        return ("Producto eliminado: " + name);

    }

    public Product editProduct(Long prodId, Map<String, Object> updatedFields) {
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
                        if(value instanceof Integer) { value = ((Integer) value).doubleValue(); } //Si el json envia un precio sin decimales, convertir a float para validar
                        p.setPrecio(validatePrice((double) value));
                        break;
                    case("stock"):
                        p.setStock(validateStock((int) value));
                        break;
                    case("categoria_id"):
                        Long id = (Long) value;
                        p.setCategoria(catServ.getCategoryById(id));
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
            System.out.println(e.getMessage());
            throw new InvalidProductDataException("Verifique los datos de entrada");
        }

        return prodRepo.save(p);
    }
}
