package cn.gzy.controller;

import cn.gzy.dto.OrderDto;
import cn.gzy.entity.Customer;
import cn.gzy.entity.Order;
import cn.gzy.entity.OrderList;
import cn.gzy.service.FoodService;
import cn.gzy.service.OrderService;
import cn.gzy.vo.OrderListVo;
import cn.gzy.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/order")

public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private FoodService foodService;

    @GetMapping("/showOrders")
    public String showOrders(HttpSession session, Model model) {
        Customer customer = (Customer) session.getAttribute("me");
        if (customer == null) {
            return "redirect:/login";
        }
        List<Order> orders = orderService.findByCustomer(customer.customerId());
        model.addAttribute("orders", orders);
        return "order";
    }
///showOrder/{orderId}
    @GetMapping("/showOrder/{orderId}")
    public String showOrder(@PathVariable("orderId") Integer orderId, Model model) {
        Order order = orderService.findOrderByOrderId(orderId);
        List<OrderList> orders = orderService.findOrderListByOrderid(orderId);
        System.err.println(order);
        System.err.println(orders);
        List<OrderListVo> voList = orders.stream().map(item -> {
            OrderListVo vo = new OrderListVo(
                    item.getOrderList(), item.getOrderListOrderid(), null, item.getOrderNumber(),
                    item.getOrderCost(), item.getOrderListStatus()
            );
            vo.setOrderFood(foodService.findById(item.getOrderFoodId()));
            return vo;
        }).collect(Collectors.toList());
        OrderVo orderVo = new OrderVo(order);
        orderVo.setList(voList);
        model.addAttribute("orderVo", orderVo);
        return "orderList";
    }



    @PostMapping("/createOrder")
    @ResponseBody
    public Object creatOrder(@RequestBody OrderDto orderDetail) {
        Integer newOne = orderService.addOrder(orderDetail);
        orderDetail.setOrderId(newOne);
        return newOne != null ? orderDetail.getOrder() : null;
    }

    @PostMapping("/commitOrder")
    @ResponseBody
    public Map<String, String> commitOrder(@RequestBody OrderDto orderDto) {
        orderDto.getList().stream().forEach(item -> {
            orderService.updateOrderListStatus(item);
        });
        orderDto.setAmount();
        orderService.updateOrderStatus(orderDto.getOrderId(),2,orderDto.getOrderAmount());
        Map<String,String> map=new HashMap<String,String>();
        map.put("msg","ok");
        return map;
    }
    @PostMapping("/settlement")
    @ResponseBody
    public Map<String,String> settlement(@RequestBody Order order){
        orderService.updateOrderStatus(order.getOrderId(),3,order.getOrderAmount());
        orderService.findOrderListByOrderid(order.getOrderId()).stream().forEach(
                orderList -> {
                    orderList.setOrderListStatus(4);
                    orderService.updateOrderListStatus(orderList);
                }
        );
        Map<String,String> map=new HashMap<String,String>();
        map.put("msg","ok");
        return map;
    }



}
