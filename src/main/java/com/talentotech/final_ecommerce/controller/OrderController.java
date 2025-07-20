package com.talentotech.final_ecommerce.controller;

import com.talentotech.final_ecommerce.dto.OrderDTO;
import com.talentotech.final_ecommerce.dto.order_request.OrderRequest;
import com.talentotech.final_ecommerce.dto.order_request.OrderUpdateRequest;
import com.talentotech.final_ecommerce.enums.OrderStatus;
import com.talentotech.final_ecommerce.model.Order;
import com.talentotech.final_ecommerce.response.ResponseHandler;
import com.talentotech.final_ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    @Autowired
    OrderService service;

    @GetMapping("/user/{id}")
    public ResponseEntity<List<OrderDTO>> findOrdersByUser(@PathVariable Long id){
        List<OrderDTO> oList = service.getOrdersByUser(id).stream()
                .map(Order::getDTO).toList();
        return ResponseHandler.buildResponse("Ordenes del usuario obtenidas con exito",
                HttpStatus.OK,
                oList);
    }


    @PostMapping("/")
    public ResponseEntity<OrderDTO> placeOrder(@RequestBody OrderRequest request){
        return ResponseHandler.buildResponse("Pedido creado con exito",
                HttpStatus.CREATED,
                service.placeOrder(request).getDTO());

    }

    @PatchMapping("/{id}")
    public ResponseEntity<OrderDTO> changeOrderStatus(@PathVariable Long id,
                                                      @RequestBody OrderUpdateRequest request){
        return ResponseHandler.buildResponse("Estado de pedido cambiado con exito",
                HttpStatus.OK,
                service.changeOrderStatus(id, request).getDTO());
    }




}
