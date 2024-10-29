package cn.gzy.service;

import cn.gzy.entity.Food;

import java.util.List;

public interface FoodService {
    List<Food> findFoodsByType(String type);
    Food findById(Integer id);
    List<Food> recommendBySales();
    List<String> foodTyleList();


}
