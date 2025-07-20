package com.talentotech.final_ecommerce.controller;

import com.talentotech.final_ecommerce.model.User;
import com.talentotech.final_ecommerce.response.ResponseHandler;
import com.talentotech.final_ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/")
    public ResponseEntity<String> registerUser(@RequestBody User usuario){
        return ResponseHandler.buildResponse("Usuario creado con exito",
                HttpStatus.CREATED,
                service.registerUser(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return ResponseHandler.buildResponse("Usuario eliminado con exito",
                HttpStatus.OK,
                service.deleteUser(id));
    }


}
