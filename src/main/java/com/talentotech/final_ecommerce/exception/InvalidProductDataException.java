package com.talentotech.final_ecommerce.exception;

import org.springframework.http.HttpStatus;

public class InvalidProductDataException extends ShopApiException {
    public InvalidProductDataException(String message) {
        super("El producto especificado no es valido. " + message,
                HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
