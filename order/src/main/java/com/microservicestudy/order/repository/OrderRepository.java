package com.microservicestudy.order.repository;

import com.microservicestudy.order.domain.entity.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository <Order, Long> {

    @Query(value = "select o from Order o WHERE o.store = :storeId")
    List<Order> getOrdersByStore(@Param("storeId") Long storeId, Pageable pageable);

}
