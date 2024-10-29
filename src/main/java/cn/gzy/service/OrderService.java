package cn.gzy.service;

import cn.gzy.dto.OrderDto;
import cn.gzy.entity.Order;
import cn.gzy.entity.OrderList;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    List<Order> findByCustomer(int id);
    Integer addOrder(OrderDto orderDto);
    Order findOrderByOrderId(int id);

    List<OrderList> findOrderListByOrderid(int orderId);


   int updateOrderListStatus(OrderList orderList);
    int updateOrderStatus(int id, int status, BigDecimal orderAmount);


}
