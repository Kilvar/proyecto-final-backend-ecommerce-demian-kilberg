package com.talentotech.final_ecommerce.enums;

import java.util.HashMap;
import java.util.Map;

public enum OrderStatus {
    ORDER_PENDING, ORDER_CANCELLED, ORDER_DELIVERED, ORDER_RESCHEDULED;

    @Override
    public String toString() {
        Map<OrderStatus, String> m = new HashMap<>();
        m.put(ORDER_PENDING, "Pendiente");
        m.put(ORDER_CANCELLED, "Cancelado");
        m.put(ORDER_DELIVERED, "Entregado");
        m.put(ORDER_RESCHEDULED, "Reprogramado");
        return m.get(this);
    }
}
