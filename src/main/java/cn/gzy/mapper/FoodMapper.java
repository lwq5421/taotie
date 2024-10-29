package cn.gzy.mapper;

import cn.gzy.entity.Food;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FoodMapper {

    @Select("select * from food where food_type=#{type}")
    List<Food> findFoodsByType(String type);
    @Select("select * from food where food_id=#{id}")
    Food findById(Integer id);
    @Select(""+
            "<script>"+
            "select * from food where food_id in"+
            "<foreach item='item' index='index' collection='list'" +
            " open='(' separator=',' close=')'>"+
            "#{item}"+
            "</foreach>"+
            "</script>")
    public List<Food> top3Food(List<Integer> list);
//    使用MyBatis的@Select注解，编写一个SQL语句，用于查询食品信息。
//    SQL语句中使用了<foreach>标签，用于遍历传入的食品ID列表list，
//    将列表中的每个食品ID插入到SQL语句中。

     @Select("select distinct food_type  from food")
    public List<String> foodTypeList();
//    使用MyBatis的@Select注解，编写一个SQL语句，用于查询食品类型列表。
//    SQL语句中使用了select distinct food_type from food，
//    表示查询食品表中所有不重复的食品类型。


}
