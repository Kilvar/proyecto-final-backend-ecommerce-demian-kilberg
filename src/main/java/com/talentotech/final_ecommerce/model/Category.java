package com.talentotech.final_ecommerce.model;

import com.talentotech.final_ecommerce.dto.CategoryDTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "categorias")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int categoria_id;
    String nombre_categoria;

    public CategoryDTO getDTO(){
        return new CategoryDTO(categoria_id, nombre_categoria);
    }

}
