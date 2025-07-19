package com.talentotech.final_ecommerce.exception;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends ShopApiException {
    public ProductNotFoundException(){
        super("No se encontro ningun producto",
                HttpStatus.NOT_FOUND);
    }

    public ProductNotFoundException(int id) {
        super(String.format("No se pudo encontrar el producto con el ID: %d", id),
                HttpStatus.NOT_FOUND);
    }

    public ProductNotFoundException(String name) {
        super(String.format("No se pudo encontrar ningun producto con el nombre: %s", name),
                HttpStatus.NOT_FOUND);
    }
}
