package cn.gzy.mapper;

import cn.gzy.entity.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
@Repository
public interface OrderMapper {

    @Insert("insert into `order` values (#{orderId},#{orderCustomerId},#{orderCreateTime},#{orderAmount},#{orderStatus})")
    @Options(useGeneratedKeys = true,keyProperty = "orderId")
    int insertOne(Order order);

    @Select("select * from `order` where order_customer_id = #{id}")
    @Results(id = "orderBase",value = {
            @Result(column = "order_id",property = "orderId"),
            @Result(column = "order_customer_id",property = "orderCustomerId"),
            @Result(column = "order_create_time",property = "orderCreateTime"),
            @Result(column = "order_amount",property = "orderAmount"),
            @Result(column = "order_status",property = "orderStatus")
    })
    List<Order> findByCustomer(int id);

    @Select("select * from `order` where order_id = #{id}")
    @ResultMap("orderBase")
    Order findByOrderId(int id);
    @Update("update `order` set order_status = #{status} where order_id = #{id}")
    int updateOrderStatus(@Param("id")int id, @Param("status")int status);
    @Update("update `order` set order_amount = #{amount} where order_id = #{id}")
    int updateOrderAmount(@Param("id")int id, @Param("amount") BigDecimal amount);


}
