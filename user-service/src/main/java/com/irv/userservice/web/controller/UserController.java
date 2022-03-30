package com.irv.userservice.web.controller;

import com.irv.userservice.exceptions.UserNotFoundException;
import com.irv.userservice.service.UserService;
import com.irv.userservice.web.mapper.UserMapper;
import com.irv.userservice.web.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    private final UserMapper mapper;
    private UserDto user;
    private List<UserDto> users;

    @GetMapping()
    private ResponseEntity<?> getAll() throws Exception {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    @PostMapping()
    private ResponseEntity<?> save(@Valid @RequestBody UserDto userDto) throws Exception {
        try{
            user = service.add(userDto);
        }catch (Exception exception){
            throw exception;
        }
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception {
        try{
            user = service.findById(id);
        }catch (Exception exception){
            throw exception;
        }
        return  new ResponseEntity<>(user,HttpStatus.OK);
    }
}
