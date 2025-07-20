package com.talentotech.final_ecommerce.dto.order_request;

public record OrderRequestItem(
        Long productoId,
        int cantidad
) { }
