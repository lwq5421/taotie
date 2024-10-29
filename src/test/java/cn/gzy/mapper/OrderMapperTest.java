package cn.gzy.mapper;

import cn.gzy.entity.Order;
import cn.gzy.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringJUnitConfig
@ContextConfiguration("classpath:applicationContext.xml")
public class OrderMapperTest {
    @Autowired
    OrderMapper orderMapper;
    @Test
    void insertOne() {
        Order order = new Order(
                null,
                1,
                LocalDateTime.of(2024,3,29,12,34,22),
                new BigDecimal("35.5"),
                2);
        System.out.println(orderMapper.insertOne(order));
        System.out.println(order);
    }

    @Test
    void findByCustomer() {
        System.out.println(orderMapper.findByCustomer(1));
    }

    @Test
    void updateOrderStatus() {
        System.out.println(orderMapper.updateOrderStatus(5,1));
    }

    @Test
    void findByOrderId() {
        System.out.println(orderMapper.findByOrderId(2));
    }

    @Test
    void updateOrderAmount() {
        System.out.println(orderMapper.updateOrderAmount(3,new BigDecimal(66)));
    }
}