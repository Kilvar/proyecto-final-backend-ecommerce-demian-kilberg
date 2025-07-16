package com.talentotech.final_ecommerce.exception;

public class InvalidProductDataException extends ShopApiException {
    public InvalidProductDataException() {
        super("El producto a crear no es valido. Stock y/o Precio deben ser mayores a 0");
    }
}
