package com.talentotech.final_ecommerce.service;

import com.talentotech.final_ecommerce.exception.UserNotFoundException;
import com.talentotech.final_ecommerce.model.User;
import com.talentotech.final_ecommerce.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public User getUserById(Long userId){
        return userRepo.findById(userId)
                .orElseThrow(()-> new UserNotFoundException(
                        String.format("El id %d no es valido", userId)
                ));
    }

    public String registerUser(User u){
        userRepo.save(u);
        return String.format("Usuario creado: %s (%d)", u.getNombreUsuario(), u.getUsuarioId());
    }

    public String deleteUser(Long userId) {
        userRepo.delete(getUserById(userId));
        return "Usuario " + userId + " eliminado";
    }
}
