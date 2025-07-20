package com.talentotech.final_ecommerce.dto;

public record OrderItemDTO(
        String nombre_producto,
        int cantidad,
        double precio_unidad,
        double subtotal
) {
}
