package com.talentotech.final_ecommerce.exception;

public class InvalidProductDataException extends ShopApiException {
    public InvalidProductDataException() {
        super("El producto especificado no es valido. Stock y/o Precio deben ser mayores a 0");
    }

    public InvalidProductDataException(int id) {
        super(String.format("El producto especificado no es valido. No existe categoria con id: %d", id));
    }
}
