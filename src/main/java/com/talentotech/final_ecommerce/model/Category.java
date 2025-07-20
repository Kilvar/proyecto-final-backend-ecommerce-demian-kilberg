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
    private Long categoriaId;

    private String nombreCategoria;

    protected Category() {}

    public Category(String name){
        this.nombreCategoria = name;
    }

    public CategoryDTO getDTO(){
        return new CategoryDTO(categoriaId, nombreCategoria);
    }

}
