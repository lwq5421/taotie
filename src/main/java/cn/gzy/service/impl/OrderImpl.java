package cn.gzy.service.impl;

import cn.gzy.dto.OrderDto;
import cn.gzy.entity.Food;
import cn.gzy.entity.Order;
import cn.gzy.entity.OrderList;
import cn.gzy.mapper.FoodMapper;
import cn.gzy.mapper.OrderListMapper;
import cn.gzy.mapper.OrderMapper;
import cn.gzy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private FoodMapper foodMapper;
    @Autowired
    private OrderListMapper orderListMapper;
    @Override
    public List<Order> findByCustomer(int id) {
        return orderMapper.findByCustomer(id);
    }
    @Override
    public Integer addOrder(OrderDto orderDto) {
        Order order = orderDto.getOrder();
        if (Optional.ofNullable(order).isEmpty()) {
            return null;
        }
        if (orderDto.getList().size() == 0) {
            return null;
        }
        int newOrder = orderMapper.insertOne(order);
        int newList = 0;
        List<OrderList> list = orderDto.getList().stream().map(
                orderList -> {
                    orderList.setOrderListOrderid(order.getOrderId());
                    orderList.setOrderNumber(1);
                    orderList.setOrderListStatus(1);
                    Food food = foodMapper.findById(orderList.getOrderFoodId());
                    orderList.setOrderCost(food.foodPrice());
                    return orderList;
                }
        ).collect(Collectors.toList());
        orderDto.setList(list);
        orderDto.setAmount();
        if (newOrder == 1) {
            newList = orderListMapper.insertList(list);
        }
        return newOrder > 0 && newList > 0 ? order.getOrderId() : null;
    }
    public Order findOrderByOrderId(int id){
        return orderMapper.findByOrderId(id);
    }
    public  List<OrderList> findOrderListByOrderid(int id){
        return orderListMapper.findByOrderid(id);
    }
    public int updateOrderListStatus(OrderList orderList) {
        return orderListMapper.updateOrderListStatus(orderList);
//        return orderListMapper.updateOrderListStatus(orderList.getOrderListOrderid(),orderList.getOrderListStatus());
    }

    public int updateOrderStatus(int id, int status, BigDecimal orderAmount){
         int a= orderMapper.updateOrderStatus(id,status);
         Optional.ofNullable(orderAmount).ifPresent(amount -> orderMapper.updateOrderAmount(id,amount));
         return  a;
    }


//    public  void setOrderMapper(OrderMapper orderMapper){
//        this.orderMapper = orderMapper;
//    }

}
