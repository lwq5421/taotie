package cn.gzy.service.impl;

import cn.gzy.entity.Food;
import cn.gzy.mapper.FoodMapper;
import cn.gzy.service.FoodService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FoodImpl implements FoodService {
    private FoodMapper foodMapper;
    public FoodMapper getFoodMapper(){
        return foodMapper;
    }
    public void setFoodMapper(FoodMapper foodMapper){
        this.foodMapper = foodMapper;
    }
    @Override
    public List<Food> findFoodsByType(String type){
        return foodMapper.findFoodsByType(type);
    }
    @Override
    public Food findById(Integer id){

        return foodMapper.findById(id);
    }
    @Override
    public List<Food> recommendBySales(){
        List<Integer> top3= Arrays.asList(2,1,4);
        return foodMapper.top3Food(top3);
    }
    @Override
    public List<String> foodTyleList(){
        return foodMapper.foodTypeList();
    }


}
