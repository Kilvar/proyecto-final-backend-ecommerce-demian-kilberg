package com.talentotech.final_ecommerce.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends ShopApiException {
    public UserNotFoundException(String message) {
        super("No se ha encontrado el usuario." + message,
                HttpStatus.NOT_FOUND);
    }
}
