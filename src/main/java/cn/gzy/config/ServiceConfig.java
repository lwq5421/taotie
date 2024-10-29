package cn.gzy.config;

import cn.gzy.mapper.FoodMapper;
import cn.gzy.service.FoodService;
import cn.gzy.service.impl.FoodImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class ServiceConfig {
    @Bean
    public FoodService foodService(FoodMapper foodMapper){
        FoodImpl f=new FoodImpl();
        f.setFoodMapper(foodMapper);
        return f;
    }
}
