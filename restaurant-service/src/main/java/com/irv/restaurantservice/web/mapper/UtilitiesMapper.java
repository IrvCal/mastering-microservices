package com.irv.restaurantservice.web.mapper;

import com.irv.restaurantservice.domain.Table;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UtilitiesMapper {
    public String objectToString(Object o){
        return o.toString();
    }
    public String stringToObject(String s){
        return s;
    }
}
