package com.talentotech.final_ecommerce.exception;

public class ProductNotFoundException extends ShopApiException {
    public ProductNotFoundException(int id) {
        super(String.format("No se pudo encontrar el producto con el ID: %d", id));
    }

    public ProductNotFoundException(String name) {
        super(String.format("No se pudo encontrar ningun producto con el nombre: %s", name));
    }
}
