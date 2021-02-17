package org.example.model.session;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.model.response.OperationResponse;

/**
 * @Author: Mae
 * @Date: 2021/2/18 2:18 上午
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SessionResponse extends OperationResponse {
    @ApiModelProperty(required = true, value = "")
    private SessionItem item;
}
