package com.talentotech.final_ecommerce.repository;

import com.talentotech.final_ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    Optional<Category> findBynombreCategoriaIgnoreCase(String nombre_categoria);
}
