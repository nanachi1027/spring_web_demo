package org.example.repo;

import org.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Mae
 * @Date: 2021/2/18 12:13 上午
 */
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    List<Customer> findAll();

    Page<Customer> findAll(Pageable p);

    Customer save(Customer c);

    void delete(Customer c);

    void delete(Integer id);

    boolean exists(Integer id);
}
