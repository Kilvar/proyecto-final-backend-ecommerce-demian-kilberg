package com.talentotech.final_ecommerce.model;

import com.talentotech.final_ecommerce.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "productos")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productoId;
    private String nombre;
    private String descripcion;
    @Column(precision = 10, scale = 2)
    BigDecimal precio;
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Category categoria;
    private int stock;
    private String url_imagen;

    public ProductDTO getDTO(){
        return new ProductDTO(productoId, nombre, descripcion, precio.doubleValue(), categoria.getDTO(), stock, url_imagen);
    }
}
