package cn.gzy.mapper;

import cn.gzy.entity.OrderList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringJUnitConfig
@ContextConfiguration(locations = "classpath:applicationContext.xml")

class OrderListMapperTest {
    @Autowired
    private OrderListMapper orderListMapper;

    @Test
    void insertList() {
        List<OrderList> list = Arrays.asList(
                new OrderList(null, 5, 1, 1, new BigDecimal("3.5"), 1),
                new OrderList(null, 5, 3, 1, new BigDecimal("14.0"), 2),
                new OrderList(null, 5, 4, 1, new BigDecimal("2.0"), 3),
                new OrderList(null, 5, 6, 1, new BigDecimal("16.0"), 2)
        );
        System.out.println(orderListMapper.findByOrderid(5));
    }

    @Test
    void findByOrderid() {
        System.out.println(orderListMapper.findByOrderid(5));
    }

//    @Test
//    void updateOrderListStatus() {
//        System.out.println(orderListMapper.updateOrderListStatus(9,2));
//    }

    @Test
    void top3() {
    }
}