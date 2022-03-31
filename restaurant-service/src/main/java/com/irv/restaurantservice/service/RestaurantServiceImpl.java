package com.irv.restaurantservice.service;


import com.irv.restaurantservice.domain.Restaurant;
import com.irv.restaurantservice.exceptions.DuplicateRestaurantException;
import com.irv.restaurantservice.exceptions.RestaurantNotFoundException;
import com.irv.restaurantservice.web.mapper.RestaurantMapper;
import com.irv.restaurantservice.web.mapper.TableMapper;
import com.irv.restaurantservice.web.model.RestaurantDto;
import com.irv.restaurantservice.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService{

    private final RestaurantRepository repository;
    private final RestaurantMapper restaurantMapper;
    private final TableMapper tableMapper;
    private RestaurantDto restaurant;
    private Collection<RestaurantDto> restaurants;

    @Override
    public RestaurantDto update(String id,RestaurantDto restaurantDto) throws Exception {
        Restaurant restaurant = repository.findById(id).orElseThrow(RestaurantNotFoundException::new);
        restaurant.setName(restaurantDto.getName());
        restaurant.setAddress(restaurantDto.getAddress());
        restaurant.setTables(tableMapper.tablesDtoToTables(restaurantDto.getTables()));
        return restaurantMapper.restaurantToRestaurantDto(repository.save(restaurant));
    }

    @Override
    public void delete(String id) throws Exception {
        repository.delete(repository.findById(id).orElseThrow(RestaurantNotFoundException::new));
//       Optional.of(repository.getById(id)).ifPresentOrElse(repository::delete, RestaurantNotFoundException::new);
    }
    @Override
    public RestaurantDto add(RestaurantDto restaurant) throws Exception{
        if(repository.findByName(restaurant.getName()).isPresent()){
            Object[] args = {restaurant.getName()};
            throw new DuplicateRestaurantException("ya tiene un restaurante con el mismo nombre",args);
        }
        return restaurantMapper.restaurantToRestaurantDto(repository.save(restaurantMapper.restaurantDtoToRestaurant(restaurant)));
    }


    //ESTE ESTA MAL LO PRESIENTO
    @Override
    public RestaurantDto findById(String restaurantId) throws Exception {
//        restaurant = restaurantMapper.restaurantToRestaurantDto( Optional.of(repository.getById(restaurantId)).orElseThrow(RestaurantNotFoundException::new));

//        Optional.of(repository.getById(restaurantId)).ifPresentOrElse(restaurant1 -> {
//            RestaurantDto restaurantDto1 = restaurantMapper.restaurantToRestaurantDto(restaurant1);
//            if(restaurantDto1.getName() != null)
//    //                        throw new RestaurantNotFoundException("No se encontro en DB");
//                restaurant = restaurantDto1;
//        }, RestaurantNotFoundException::new);
        /*
        try{

            restaurant = restaurantMapper.restaurantToRestaurantDto(repository.getById(restaurantId));
        }catch (Exception e){
            throw new RestaurantNotFoundException();
        }
        return restaurant;*/

        return repository.findById(restaurantId).map(restaurantMapper::restaurantToRestaurantDto).orElseThrow(RestaurantNotFoundException::new);//podria hacer el mapper primero en lugar de hacerlo en la lambda pero ya mejor lo dejo ahi
    }
    @Override
    public Collection<RestaurantDto> findByName(String name) throws Exception {
        /*
        1. este fue mi primer intento pero no me convencio
        repository.findByName(name).ifPresent(
                restaurant -> restaurants.add(restaurantMapper.restaurantToRestaurantDto(restaurant))
        );
        if(!(restaurants.size() >0))
            throw new RestaurantNotFoundException();
        */

        /*
        2. este fue mi segundo intento pero tampoco me convencio PERO
        me di cuenta que con los optional afuerzas tengo que colocar orElseThrow
        para hacer un throw de una excepcion nada mas jala
        Restaurant restaurant = repository.findByName(name).orElseThrow(RestaurantNotFoundException::new);
        restaurants.add(restaurantMapper.restaurantToRestaurantDto(restaurant));
        */
        //tercer y utlimo intento, si no esta es un Optional.empty() EL SEGUNDO ES EL BUENO PARA TODO LO DEMAS PERO EN ESTE LO DEJO ASI
//       ESTE ES EL SEGUNDO: repository.findByName(name).map(restaurant1 -> restaurants.add(restaurantMapper.restaurantToRestaurantDto(restaurant1))).orElseThrow(RestaurantNotFoundException::new);

        restaurants.add(restaurantMapper.restaurantToRestaurantDto(repository.findByName(name).orElseThrow(RestaurantNotFoundException::new)));
        return restaurants;
    }

    @Override
    public Collection<RestaurantDto> findAll() {
        return restaurantMapper.listRestaurantToListRestaurantDto(repository.findAll());
    }

    @Override
    public Collection<RestaurantDto> findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
        throw new UnsupportedOperationException(
                "Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
