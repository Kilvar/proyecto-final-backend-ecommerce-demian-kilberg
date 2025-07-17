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
    private int producto_id;
    private String nombre;
    private String descripcion;
    private double precio;
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Category categoria;
    private int stock;
    private String url_imagen;

    public ProductDTO getDTO(){
        return new ProductDTO(producto_id, nombre, descripcion, precio, categoria.getDTO(), stock, url_imagen);
    }
}
