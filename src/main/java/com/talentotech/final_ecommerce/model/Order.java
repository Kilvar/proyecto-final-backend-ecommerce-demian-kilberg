package com.talentotech.final_ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "pedidos")
@Data

public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long order_id;

    @OneToMany(mappedBy = "order")
    List<Product> productList;
    String orderStatus;
}
