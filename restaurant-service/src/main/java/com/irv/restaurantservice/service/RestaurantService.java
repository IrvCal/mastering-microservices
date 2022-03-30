package com.irv.restaurantservice.service;

import com.irv.restaurantservice.web.model.RestaurantDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public interface RestaurantService {
    RestaurantDto add(RestaurantDto restaurant) throws Exception;
    RestaurantDto update(String id,RestaurantDto restaurant) throws Exception;
    void delete(String id) throws Exception;
    RestaurantDto findById(String restaurantId) throws Exception;
    Collection<RestaurantDto> findByName(String name) throws Exception;
    Collection<RestaurantDto> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
    Collection<RestaurantDto> findAll();
}
