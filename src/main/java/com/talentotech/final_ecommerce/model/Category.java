package com.talentotech.final_ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "categorias")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int categoria_id;
    String nombreCategoria;
}
