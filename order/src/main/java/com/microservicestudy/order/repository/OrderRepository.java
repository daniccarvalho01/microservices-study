package com.microservicestudy.order.repository;

import com.microservicestudy.order.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository <Order, Long> {

    @Query(value = "select o from orders o WHERE o.store_id = ? ORDER BY id DESC LIMIT 2")
    List<Order> getOrdersByStore(Long storeId);

}
