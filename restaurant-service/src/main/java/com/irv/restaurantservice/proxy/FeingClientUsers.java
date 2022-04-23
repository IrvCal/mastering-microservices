package com.irv.restaurantservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("user-service")
public interface FeingClientUsers {
    @GetMapping("v1/users")
    List<Object> getUsers();
}
