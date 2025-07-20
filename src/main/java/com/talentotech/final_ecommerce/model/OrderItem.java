package com.talentotech.final_ecommerce.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "items_pedido")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itempedidoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id", nullable = false)
    private Order pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", nullable = false)
    private Product producto;

    private int cantidad;

    @Column(precision = 10, scale = 2)
    private BigDecimal precio_unidad;

    protected OrderItem() {}

    public OrderItem(Order o, Product p, int quantity, BigDecimal price){
        this.pedido = o;
        this.producto = p;
        this.cantidad = quantity;
        this.precio_unidad = price;
    }


    public BigDecimal getSubtotalItem(){
        return BigDecimal.valueOf(cantidad).multiply(precio_unidad);
    }

}
