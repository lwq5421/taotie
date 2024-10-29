package cn.gzy.mapper;

import cn.gzy.entity.OrderList;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderListMapper {

    @Insert("<script>" +
            "insert into `order_list` values " +
            "<foreach item='item' collection='list' separator=','>" +
            "(null,#{item.orderListOrderid},#{item.orderFoodId},#{item.orderNumber},#{item.orderCost},#{item.orderListStatus})" +
            "</foreach>" +
            "</script>")
    Integer insertList(List<OrderList> list);

    @Select("select * from `order_list` where order_list_orderid = #{id}")
    @Results(id="orderListMap",value = {
            @Result(column = "order_list",property = "orderList"),
            @Result(column = "order_list_orderid",property = "orderListOrderid"),
            @Result(column = "order_food_id",property = "orderFoodId"),
            @Result(column = "order_number",property = "orderNumber"),
            @Result(column = "order_cost",property = "orderCost"),
            @Result(column = "order_list_status",property = "orderListStatus"),
    })
    List<OrderList> findByOrderid(int id);

    @Update("update `order_list` set order_list_status = #{orderListStatus}," +
            "order_cost = #{orderCost},order_number=#{orderNumber} where order_list = #{orderList} ")
    int updateOrderListStatus(OrderList orderList);

    @Select("select order_list FROM " +
            "(select any_value(order_list) order_list,order_food_id,sum(order_number) sumNumber from order_list group by order_food_id)" +
            "as o order by sumNumber desc limit 3")
    List<Integer> top3();
}
