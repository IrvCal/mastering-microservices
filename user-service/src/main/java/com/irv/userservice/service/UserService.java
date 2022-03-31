package com.irv.userservice.service;

import com.irv.userservice.web.model.UserDto;

import java.util.Collection;
import java.util.List;

public interface UserService {
    UserDto add(UserDto userDto)throws Exception;
    UserDto update(Long id,UserDto userDto) throws Exception;
    void delete(Long id)throws Exception;
    UserDto findById(Long id) throws Exception;
    Collection<UserDto> findAll()throws Exception;
    List<UserDto> findByName(String name)throws Exception;
}
