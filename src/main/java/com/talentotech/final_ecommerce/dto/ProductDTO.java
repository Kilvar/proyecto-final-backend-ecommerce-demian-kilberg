package com.talentotech.final_ecommerce.dto;

import com.talentotech.final_ecommerce.model.Category;

public record ProductDTO(
        int id,
        String nombre,
        String descripcion,
        double precio,
        CategoryDTO categoria,
        int stock,
        String url_imagen) {
}
