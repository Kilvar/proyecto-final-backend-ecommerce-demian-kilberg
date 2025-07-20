package com.talentotech.final_ecommerce.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ShopApiException extends RuntimeException {

    final HttpStatus returnStatus;

    public ShopApiException(String message, HttpStatus returnStatus) {
        super(message);
        this.returnStatus = returnStatus;
    }


}
