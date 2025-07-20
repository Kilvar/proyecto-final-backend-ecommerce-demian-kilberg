package com.talentotech.final_ecommerce.exception;

import org.springframework.http.HttpStatus;

public class OrderNotFoundException extends ShopApiException {
    public OrderNotFoundException(Long id) {
        super(String.format("No se encontro el pedido con id %d", id),
                HttpStatus.NOT_FOUND);
    }
}
