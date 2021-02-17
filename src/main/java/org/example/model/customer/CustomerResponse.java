package org.example.model.customer;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.model.response.PageResponse;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * @Author: Mae
 * @Date: 2021/2/18 12:18 上午
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class CustomerResponse extends PageResponse {
    @ApiModelProperty(required = true, value = "")
    private List<Customer> items;
}
