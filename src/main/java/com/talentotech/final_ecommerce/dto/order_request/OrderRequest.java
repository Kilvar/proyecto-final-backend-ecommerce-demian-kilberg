package com.talentotech.final_ecommerce.dto.order_request;

import java.util.List;

public record OrderRequest(
        Long usuarioId,
        List<OrderRequestItem> itemsPedido
){ }
