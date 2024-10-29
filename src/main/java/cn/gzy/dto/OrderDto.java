package cn.gzy.dto;

import cn.gzy.entity.Order;
import cn.gzy.entity.OrderList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto{

    private Integer orderId;
    private LocalDateTime orderCreateTime;
    private Integer customerId;
    private Integer orderStatus;
    private List<OrderList> list;
    private BigDecimal orderAmount;
    public Order getOrder(){
        if (this.getOrderCreateTime() == null){
            this.setOrderCreateTime(LocalDateTime.now());
        }
        if (this.getOrderStatus() == null){
            this.setOrderStatus(1);
        }
        return new Order(orderId,customerId,orderCreateTime,orderAmount,orderStatus);
    }

    public void setAmount() {
        BigDecimal total = this.list.stream()
                .map(OrderList -> OrderList.getOrderCost())
                .reduce(new BigDecimal(0.00),(n1, n2)->n1.add(n2));
        this.orderAmount =total;
    }

}