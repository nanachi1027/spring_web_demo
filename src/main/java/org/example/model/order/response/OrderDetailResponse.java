package org.example.model.order.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.model.order.OrderDetail;
import org.example.model.response.PageResponse;

import java.util.List;

/**
 * @Author: Mae
 * @Date: 2021/2/18 2:14 上午
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OrderDetailResponse extends PageResponse {
    @ApiModelProperty(required = true, value = "")
    private List<OrderDetail> items;
}
