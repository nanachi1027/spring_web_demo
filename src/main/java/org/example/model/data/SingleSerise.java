package org.example.model.data;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: Mae
 * @Date: 2021/2/18 3:15 上午
 */
@Data
public class SingleSerise {
    private String name;
    private BigDecimal value;

    public SingleSerise(String name, BigDecimal value) {
        this.name = name;
        this.value = value;
    }
}
