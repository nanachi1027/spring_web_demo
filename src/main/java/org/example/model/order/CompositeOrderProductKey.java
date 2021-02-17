package org.example.model.order;

import java.io.Serializable;

/**
 * @Author: Mae
 * @Date: 2021/2/18 2:13 上午
 */
public class CompositeOrderProductKey implements Serializable {
    private int orderId;
    private int productId;

    public CompositeOrderProductKey(int orderId, int productId) {
        this.orderId = orderId;
        this.productId = productId;
    }
}
