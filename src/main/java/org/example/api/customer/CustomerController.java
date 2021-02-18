package org.example.api.customer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.example.model.customer.Customer;
import org.example.model.customer.CustomerResponse;
import org.example.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

/**
 * @Author: Mae
 * @Date: 2021/2/18 4:40 上午
 */
@RestController
@Transactional
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = {"Customers"})
public class CustomerController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CustomerRepo customerRepo;

    @ApiOperation(value = "Get list of customers", response = CustomerResponse.class)
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public CustomerResponse getCustomerByPage(
            @ApiParam(value = "") @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @ApiParam(value = "between 1 to 1000") @RequestParam(value = "size", defaultValue = "20", required = false) Integer size,
            @RequestParam(value = "customerid", required = false) Integer customerId,
            @RequestParam(value = "company", required = false) String company,
            @RequestParam(value = "country, required = false") String country,
            Pageable pageable) {
        CustomerResponse resp = new CustomerResponse();
        Customer customer = new Customer();
        if (customerId != null) {
            customer.setId(customerId);
        }
        if (company != null) {
            customer.setCompany(company);
        }
        if (country != null) {
            customer.setCountry(country);
        }

        Page<Customer> customerPage = customerRepo.findAll(org.springframework.data.domain.Example.of(customer), pageable);
        resp.setPageStats(customerPage, true);
        resp.setItems(customerPage.getContent());
        return resp;
    }
}
