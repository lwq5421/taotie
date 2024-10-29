package cn.gzy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderList {
    private Integer orderList;
    private Integer orderListOrderid;
    private Integer orderFoodId;
    private Integer orderNumber;
    private BigDecimal orderCost;
    private Integer orderListStatus;
}
