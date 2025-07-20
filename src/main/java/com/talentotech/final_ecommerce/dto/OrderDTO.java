package com.talentotech.final_ecommerce.dto;

import com.talentotech.final_ecommerce.enums.OrderStatus;

import java.util.List;

public record OrderDTO(
    Long pedido_id,
    Long usuario_id,
    List<OrderItemDTO> itemsPedido,
    int total_items,
    double precio_total,
    OrderStatus estado_pedido
) { }
