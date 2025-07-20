package com.talentotech.final_ecommerce.repository;

import com.talentotech.final_ecommerce.model.Order;
import com.talentotech.final_ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

}
