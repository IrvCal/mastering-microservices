package com.irv.apiservice.web.controller;

import com.irv.apiservice.web.model.ErrorInfoDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class RestaurantServiceController {
    private final RestTemplate restTemplate;
    @GetMapping("/sample-api")
    @CircuitBreaker(name = "numero-veces",fallbackMethod = "hardcodedResponse")
    @RateLimiter(name = "default")
    public ResponseEntity<?> sampleApi() {

        String url = "http://localhost:8705/restaurant-service/v1/restaurants/";
        ResponseEntity<Collection> result = restTemplate.getForEntity(url,Collection.class);
        return new ResponseEntity<>(result.getBody(), HttpStatus.OK);
    }
    public ResponseEntity<?> hardcodedResponse(Exception exception) {
        return new ResponseEntity<>(ErrorInfoDto.builder()
                .status(HttpStatus.BAD_GATEWAY)
                .message("Fallo en alcanzar el destino").build()
                ,HttpStatus.BAD_GATEWAY);
    }
}
