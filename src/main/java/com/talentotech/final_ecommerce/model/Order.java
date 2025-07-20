package com.talentotech.final_ecommerce.model;

import com.talentotech.final_ecommerce.dto.OrderDTO;
import com.talentotech.final_ecommerce.dto.OrderItemDTO;
import com.talentotech.final_ecommerce.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private User usuario;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    List<OrderItem> listaItems = new ArrayList<>();

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    OrderStatus estadoPedido = OrderStatus.PENDIENTE;

    private int totalItems;
    private BigDecimal precioTotal = new BigDecimal("0");

    protected Order(){}

    public Order(User u){
        this.usuario = u;
    }

    public void addItem(Product p, int quantity){
        OrderItem i = new OrderItem(this, p, quantity, p.getPrecio());
        listaItems.add(i);
        precioTotal = precioTotal.add(i.getSubtotalItem());
        totalItems += quantity;
    }

    public OrderDTO getDTO(){

        List<OrderItemDTO> itemsPedido = listaItems.stream()
                .map(OrderItem::getDTO).toList();

        return new OrderDTO(pedidoId, usuario.getUsuarioId(), itemsPedido, totalItems, precioTotal.doubleValue(), estadoPedido);
    }

}
