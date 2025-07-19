package com.talentotech.final_ecommerce.repository;

import com.talentotech.final_ecommerce.model.Category;
import com.talentotech.final_ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    List<Product> findByNombreContainingIgnoreCase(String name);

    List<Product> findByCategoria(Category categoria);
}
