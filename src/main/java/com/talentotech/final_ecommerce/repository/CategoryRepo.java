package com.talentotech.final_ecommerce.repository;

import com.talentotech.final_ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
    Category findBynombreCategoria(String nombre_categoria);
}
