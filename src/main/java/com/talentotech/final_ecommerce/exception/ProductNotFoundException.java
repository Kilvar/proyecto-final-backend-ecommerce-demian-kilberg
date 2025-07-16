package com.talentotech.final_ecommerce.exception;

public class ProductNotFoundException extends ShopApiException {
    public ProductNotFoundException(int id) {
        super(String.format("No se pudo encontrar el producto con el ID: %d", id));
    }
}
