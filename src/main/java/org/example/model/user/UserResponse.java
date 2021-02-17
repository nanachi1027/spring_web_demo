package org.example.model.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.model.response.OperationResponse;

/**
 * @Author: Mae
 * @Date: 2021/2/18 2:19 上午
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class UserResponse extends OperationResponse {
    private User data = new User(); 
}
