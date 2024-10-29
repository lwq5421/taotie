package cn.gzy.vo;

import cn.gzy.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderListVo {
    private Integer orderListId;
    private Integer orderListOrderid;
    private Food orderFood;
    private Integer orderNumber;
    private BigDecimal orderCost;
    private Integer orderListStatus;
}