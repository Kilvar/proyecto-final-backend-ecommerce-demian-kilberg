package com.talentotech.final_ecommerce.exception;

import org.springframework.http.HttpStatus;

public class BadStockException extends ShopApiException {
    public BadStockException(String productName) {
        super(String.format("Error de pedido. Stock invalido para el producto: %s",productName),
                HttpStatus.BAD_REQUEST);
    }
}
