package org.example.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: Mae
 * @Date: 2021/2/18 12:21 上午
 */
@Data
public class OperationResponse {
    public enum ResponseStatusEnum {SUCCESS, ERROR, WARNING, NO_ACCESS}

    ;
    @ApiModelProperty(required = true)
    private ResponseStatusEnum operationStatus;
    private String operationMessage;
}
