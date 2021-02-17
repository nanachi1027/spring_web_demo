package org.example.model.customer;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: Mae
 * @Date: 2021/2/18 12:17 上午
 */
@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    private Integer id;
    private String lastName;
    private String email;
    private String company;
    private String phone;
    private String address1;
    private String address2;
    private String city ;
    private String state;
    private String postalCode;
    private String country;
    public Customer() {}
}
