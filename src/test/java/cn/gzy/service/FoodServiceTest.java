package cn.gzy.service;

import cn.gzy.config.ServiceConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@SpringJUnitConfig(value = ServiceConfig.class)

class FoodServiceTest {
    @Autowired

    private  FoodService foodService;

//    public FoodService getFoodService() {
//        return foodService;
//    }
//
//    public void setFoodService(FoodService foodService) {
//        this.foodService = foodService;
//    }

    @Test
    void findFoodByType() {
        System.out.println(foodService.findFoodsByType("红烧"));
    }

    @Test
    void findFoodId() {
        System.out.println(foodService. findById(2));
    }

    @Test
    void recommendBySales() {
        System.out.println(foodService.recommendBySales());
    }

    @Test
    void foodTypeList() {
        System.out.println(foodService.foodTyleList());
    }
}