package org.example.model.order.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.model.order.OrderInfo;
import org.example.model.response.PageResponse;

import java.util.List;

/**
 * @Author: Mae
 * @Date: 2021/2/18 2:15 上午
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OrderInfoResponse  extends PageResponse {
    @ApiModelProperty(required = true, value = "")
    private List<OrderInfo> items;
}
