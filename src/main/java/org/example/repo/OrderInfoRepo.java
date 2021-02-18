package org.example.repo;

import org.example.model.order.OrderInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Mae
 * @Date: 2021/2/18 12:14 上午
 */
public interface OrderInfoRepo extends JpaRepository<OrderInfo, Long> {
    List<OrderInfo> findAll();

    Page<OrderInfo> findAll(Pageable p);
}
