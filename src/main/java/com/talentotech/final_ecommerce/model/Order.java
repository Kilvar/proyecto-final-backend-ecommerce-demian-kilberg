package com.talentotech.final_ecommerce.model;

import com.talentotech.final_ecommerce.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Getter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedidoId;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    List<OrderItem> listaItems = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    OrderStatus estadoPedido = OrderStatus.PENDIENTE;

    private BigDecimal precioTotal = new BigDecimal("0");

    public void addItem(Product p, int quantity){
        OrderItem i = new OrderItem(this, p, quantity, p.getPrecio());
        listaItems.add(i);
        precioTotal = precioTotal.add(i.getSubtotalItem());
    }

}
