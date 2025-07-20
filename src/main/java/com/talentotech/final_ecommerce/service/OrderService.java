package com.talentotech.final_ecommerce.service;

import com.talentotech.final_ecommerce.dto.order_request.OrderRequest;
import com.talentotech.final_ecommerce.dto.order_request.OrderUpdateRequest;
import com.talentotech.final_ecommerce.exception.BadOrderException;
import com.talentotech.final_ecommerce.exception.OrderNotFoundException;
import com.talentotech.final_ecommerce.model.Order;
import com.talentotech.final_ecommerce.model.Product;
import com.talentotech.final_ecommerce.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    UserService uServ;

    @Autowired
    ProductService pServ;

    public Order placeOrder(OrderRequest request){
        var items = request.itemsPedido();
        Long userId = request.usuarioId();

        if(items.isEmpty()) throw new BadOrderException("No hay productos en el pedido");
        Order o = new Order(uServ.getUserById(userId));
        items.forEach(item -> {
            Product p = pServ.getProductById(item.productoId());
            p.subStock(item.cantidad());
            o.addItem(p, item.cantidad());
        });
        return orderRepo.save(o);
    }

    public Order changeOrderStatus(Long orderId, OrderUpdateRequest request){
        Order o = orderRepo.findById(orderId).orElseThrow(()-> new OrderNotFoundException(orderId));
        o.setEstadoPedido(request.estado());
        return orderRepo.save(o);
    }

    public List<Order> getOrdersByUser(Long userId){
        return uServ.getUserById(userId).getPedidos();
    }

}
