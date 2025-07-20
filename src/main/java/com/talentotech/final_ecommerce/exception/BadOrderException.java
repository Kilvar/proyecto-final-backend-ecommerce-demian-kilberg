package com.talentotech.final_ecommerce.exception;

import org.springframework.http.HttpStatus;

public class BadOrderException extends ShopApiException {
    public BadOrderException(String message) {
        super("Pedido invalido. " + message,
                HttpStatus.BAD_REQUEST);
    }
}
