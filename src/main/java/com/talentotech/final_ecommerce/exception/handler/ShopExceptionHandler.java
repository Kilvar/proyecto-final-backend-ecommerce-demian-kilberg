package com.talentotech.final_ecommerce.exception.handler;

import com.talentotech.final_ecommerce.exception.ShopApiException;
import com.talentotech.final_ecommerce.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class ShopExceptionHandler {

    @ExceptionHandler(value = {ShopApiException.class})
    public ResponseEntity<Object> handleException(ShopApiException e){
        return ResponseHandler.buildResponse(e.getMessage(), e.getReturnStatus(), null);
    }

    @ExceptionHandler(value = {SQLIntegrityConstraintViolationException.class})
    public ResponseEntity<Object> handleDBException(SQLException e){
        return ResponseHandler.buildResponse("Ocurrio un error de servidor, verifique los datos", HttpStatus.INTERNAL_SERVER_ERROR, null);
    }

}
