package com.talentotech.final_ecommerce.repository;

import com.talentotech.final_ecommerce.model.Category;
import com.talentotech.final_ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    Optional<List<Product>> findByNombreContainingIgnoreCase(String name);

    List<Product> findByCategoria(Category categoria);
}
