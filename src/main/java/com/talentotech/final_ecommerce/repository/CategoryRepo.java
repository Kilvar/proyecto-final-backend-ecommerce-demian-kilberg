package com.talentotech.final_ecommerce.repository;

import com.talentotech.final_ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
    Optional<Category> findBynombreCategoriaIgnoreCase(String nombre_categoria);
}
