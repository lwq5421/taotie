package cn.gzy.vo;

import cn.gzy.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderVo {
    private Integer orderId;
    private Integer orderCustomerId;
    private LocalDateTime orderCreateTime;
    private BigDecimal orderAmount;
    private Integer orderStatus;
    private List<OrderListVo> list;

    public OrderVo(Order order){
        this.orderId = order.getOrderId();
        this.orderCustomerId = order.getOrderCustomerId();
        this.orderCreateTime = order.getOrderCreateTime();
        this.orderAmount = order.getOrderAmount();
        this.orderStatus = order.getOrderStatus();
    }
}
