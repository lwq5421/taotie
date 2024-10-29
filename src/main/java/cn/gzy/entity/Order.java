package cn.gzy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Order {
    private Integer orderId;
    private Integer orderCustomerId;
    private LocalDateTime orderCreateTime;
    private BigDecimal orderAmount;
    private Integer orderStatus;
}
