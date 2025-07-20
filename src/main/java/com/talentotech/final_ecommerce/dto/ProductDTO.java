package com.talentotech.final_ecommerce.dto;

public record ProductDTO(
        Long id,
        String nombre,
        String descripcion,
        double precio,
        CategoryDTO categoria,
        int stock,
        String url_imagen) {
}
