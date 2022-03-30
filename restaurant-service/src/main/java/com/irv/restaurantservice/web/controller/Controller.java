package com.irv.restaurantservice.web.controller;

import com.irv.restaurantservice.exceptions.DuplicateRestaurantException;
import com.irv.restaurantservice.exceptions.RestaurantNotFoundException;
import com.irv.restaurantservice.service.RestaurantService;
import com.irv.restaurantservice.web.mapper.RestaurantMapper;
import com.irv.restaurantservice.domain.Restaurant;
import com.irv.restaurantservice.web.model.RestaurantDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
public class Controller {

    private final RestaurantService restaurantService;
    private final RestaurantMapper restaurantMapper;
    private RestaurantDto restaurantDto;
    private Collection<Restaurant> restaurants;

    @GetMapping("")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(restaurantService.findAll(),HttpStatus.OK);
    }

    @GetMapping("name/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) throws Exception {
        try {
            name = name.trim().toLowerCase();
            restaurants = restaurantMapper.listRestaurantDtoToListRestaurant((List<RestaurantDto>) restaurantService.findByName(name));
        }catch (RestaurantNotFoundException exception){
            log.info("No se encontro");
            throw exception;
        } catch (Exception exception) {
            log.info("Ocurrio otro error");
            throw exception;
        }
        return restaurants.size()>0 ? new ResponseEntity<>(restaurants, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(restaurantService.findById(id),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> add(@Valid @RequestBody RestaurantDto restaurantDto) throws Exception{
        try {
            this.restaurantDto = restaurantService.add(restaurantDto);
        } catch (DuplicateRestaurantException e) {
            log.info("Ya se encuentra este restaurant");
            throw e;
        }
        return new ResponseEntity<>(this.restaurantDto,HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody RestaurantDto restaurantDto,@PathVariable String id)throws Exception{
        try {
            this.restaurantDto = restaurantService.update(id,restaurantDto);
        } catch (RestaurantNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
        return new ResponseEntity<>(this.restaurantDto,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) throws Exception {
        try {
            restaurantService.delete(id);
        } catch (RestaurantNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
