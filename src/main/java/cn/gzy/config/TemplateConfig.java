package cn.gzy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

@Configuration
public class TemplateConfig {
   public  TemplateConfig(){

   }
   @Bean
    public Java8TimeDialect Java8TimeDialect(){
       return new Java8TimeDialect();
   }

}
