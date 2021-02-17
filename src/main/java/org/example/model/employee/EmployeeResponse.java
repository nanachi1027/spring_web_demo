package org.example.model.employee;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Author: Mae
 * @Date: 2021/2/18 1:50 上午
 */
@Data
@EqualsAndHashCode(callSuper =  false)
public class EmployeeResponse {
    @ApiModelProperty(required = true, value = "")
    private List<Employee> items;
}
