package com.irv.restaurantservice.proxy;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
//@RequiredArgsConstructor No encuentra el aurowired y no se porque (se puede hacer el bean manual)
public class RestTemplateUsers {
    private RestTemplate restTemplate = new RestTemplate();
    public void getUsers(){
        final String userService
                = "http://localhost:8765/user-service/v1/users";
        ResponseEntity<String> response
                = restTemplate.getForEntity(userService, String.class);
        System.out.println(response);
    }
}
