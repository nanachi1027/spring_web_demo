package org.example.repo;

import org.example.model.product.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @Author: Mae
 * @Date: 2021/2/18 12:14 上午
 */
public interface ProductRepo extends JpaRepository<Product, Integer> {
    public List<Product> findAll();

    public Page<Product> findAll(Pageable p);

    Optional<Product> findOneById(Integer id);

    Product save(Product p);

    void delete(Product p);

    void delete(Integer id);

    Product deleteById(Integer id);

    boolean exists(Integer id);
}
