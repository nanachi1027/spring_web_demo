package org.example.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.model.data.SingleSerise;

import java.util.List;

/**
 * @Author: Mae
 * @Date: 2021/2/18 12:21 上午
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SingleDataSeriseResponse extends OperationResponse {
    private List<SingleSerise> items;
}
