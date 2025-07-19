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
    @Column(name = "categoria_id")
    int categoriaId;

    @Column(name="nombre_categoria")
    String nombreCategoria;

    public CategoryDTO getDTO(){
        return new CategoryDTO(categoriaId, nombreCategoria);
    }

}
