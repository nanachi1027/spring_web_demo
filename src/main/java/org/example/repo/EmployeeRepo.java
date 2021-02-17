package org.example.repo;

import org.example.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Mae
 * @Date: 2021/2/18 12:14 上午
 */
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    List<Employee> findAll();

    Page<Employee> findAll(Pageable p);

    Employee save(Employee e);

    void delete(Employee e);

    void delete(Integer id);

    boolean exists(Integer id);
}
