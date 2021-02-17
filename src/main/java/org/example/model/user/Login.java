package org.example.model.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: Mae
 * @Date: 2021/2/18 2:18 上午
 */
@Data
public class Login {
    @ApiModelProperty(example = "demo", required = true)
    private String username = "";

    @ApiModelProperty(example = "demo", required = true)
    private String password = "";
}
