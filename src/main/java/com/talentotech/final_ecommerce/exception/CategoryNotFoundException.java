package com.talentotech.final_ecommerce.exception;

import org.springframework.http.HttpStatus;

public class CategoryNotFoundException extends ShopApiException {
    public CategoryNotFoundException(String message) {
        super("No se pudo encontrar la categoria. " + message,
                HttpStatus.NOT_FOUND);
    }
}
