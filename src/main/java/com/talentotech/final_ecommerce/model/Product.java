package com.talentotech.final_ecommerce.model;

import com.talentotech.final_ecommerce.dto.ProductDTO;
import com.talentotech.final_ecommerce.exception.BadStockException;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "productos")
@Data
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

    public void subStock(int quantity){
        if(quantity > stock || quantity <= 0) throw new BadStockException(nombre);
        stock -= quantity;
    }

}
