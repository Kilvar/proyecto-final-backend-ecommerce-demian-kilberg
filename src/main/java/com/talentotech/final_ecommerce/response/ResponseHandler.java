package com.talentotech.final_ecommerce.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> buildResponse(String message, HttpStatus status, Object result) {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("message", message); // Mensaje de exito o error
        response.put("status", status); // Codigo http
        response.put("result", result); // Datos del service o null si es error
        return new ResponseEntity<>(response, status);
    }
}
