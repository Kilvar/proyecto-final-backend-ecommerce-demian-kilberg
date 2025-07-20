package com.talentotech.final_ecommerce.dto.order_request;

import com.talentotech.final_ecommerce.enums.OrderStatus;

public record OrderUpdateRequest(OrderStatus estado) {
}
