package com.talentotech.final_ecommerce.model;

import com.talentotech.final_ecommerce.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    public ProductDTO getDTO(){
        return new ProductDTO(id, nombre, precio, stock);
    }
}
