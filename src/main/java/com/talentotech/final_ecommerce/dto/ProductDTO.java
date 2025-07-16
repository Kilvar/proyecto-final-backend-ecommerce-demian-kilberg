package com.talentotech.final_ecommerce.dto;

import com.talentotech.final_ecommerce.model.Product;

public record ProductDTO(
        int id,
        String name,
        double price,
        int stock) {
}
