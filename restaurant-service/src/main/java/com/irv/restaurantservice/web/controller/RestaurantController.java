package com.irv.restaurantservice.web.controller;

import com.irv.restaurantservice.proxy.FeingClientUsers;
import com.irv.restaurantservice.proxy.RestTemplateUsers;
import com.irv.restaurantservice.service.RestaurantService;
import com.irv.restaurantservice.web.mapper.RestaurantMapper;
import com.irv.restaurantservice.domain.Restaurant;
import com.irv.restaurantservice.web.model.RestaurantDto;
import com.netflix.discovery.converters.Auto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final RestaurantMapper restaurantMapper;
    private RestaurantDto restaurantDto;
    private Collection<Restaurant> restaurants;
    @Autowired
    private RestTemplateUsers restTemplateUsers;
    @Autowired
    private FeingClientUsers proxy;


    @GetMapping("")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(restaurantService.findAll(),HttpStatus.OK);
    }

    @GetMapping("name/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) throws Exception {
        restaurants = restaurantMapper.listRestaurantDtoToListRestaurant((List<RestaurantDto>) restaurantService.findByName(name));
        return restaurants.size()>0 ? new ResponseEntity<>(restaurants, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(restaurantService.findById(id),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> add(@Valid @RequestBody RestaurantDto restaurantDto) throws Exception{
        return new ResponseEntity<>(restaurantService.add(restaurantDto),HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody RestaurantDto restaurantDto,@PathVariable String id)throws Exception{
        return new ResponseEntity<>(restaurantService.update(id,restaurantDto),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) throws Exception {
        restaurantService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/restTemplate")
    public void restTemplate(){
        restTemplateUsers.getUsers();
    }
    @GetMapping("/feign")
    public void feign(){
        final List<Object> users = proxy.getUsers();
        users.forEach(System.out::println);
    }
}
/*
NOTA::::
Este fragmento corresponde al update
me di cuenta que se puede dejar directamente le firma en el metodo
para no llenar de try el controller
//        try {
//            this.restaurantDto =
//        } catch (RestaurantNotFoundException e) {
//            e.printStackTrace();
//            throw e;
//        }


 */
