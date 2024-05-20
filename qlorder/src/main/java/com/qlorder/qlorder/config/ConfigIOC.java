package com.qlorder.qlorder.config;

import com.qlorder.qlorder.entity.OrderEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigIOC {
    @Bean("order")
    public OrderEntity createOrder(){
        OrderEntity order = new OrderEntity();
        return order;
    }
}
