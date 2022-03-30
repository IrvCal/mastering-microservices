package com.irv.restaurantservice.web.mapper;

import com.irv.restaurantservice.domain.Restaurant;
import com.irv.restaurantservice.domain.Table;
import com.irv.restaurantservice.web.model.RestaurantDto;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(uses = {UtilitiesMapper.class})
public interface RestaurantMapper {
    Restaurant restaurantDtoToRestaurant(RestaurantDto restaurantDto);
    RestaurantDto restaurantToRestaurantDto(Restaurant restaurant);
    List<Restaurant> listRestaurantDtoToListRestaurant(List<RestaurantDto> restaurantDtos);
    List<RestaurantDto> listRestaurantToListRestaurantDto(List<Restaurant> restaurants);
}
