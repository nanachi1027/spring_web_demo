package org.example.repo;

import org.example.model.order.OrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Mae
 * @Date: 2021/2/18 12:14 上午
 */
public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findAll();

    Page<OrderItem> findAll(Pageable p);
}


