package com.irv.restaurantservice.repository;

import com.irv.restaurantservice.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,String> {
    Optional<Restaurant> findByName(String name);//checar porque nombre esta en Entity
    Optional<Restaurant> findById(String id);//checar porque nombre esta en Entity
}
