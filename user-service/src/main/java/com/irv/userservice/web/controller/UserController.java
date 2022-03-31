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
    private ResponseEntity<?> findAll() throws Exception {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    @PostMapping()
    private ResponseEntity<?> add(@Valid @RequestBody UserDto userDto) throws Exception {
        return new ResponseEntity<>(service.add(userDto),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(service.findById(id),HttpStatus.OK);
    }
    @PostMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody UserDto userDto,@PathVariable Long id) throws  Exception{
        return new ResponseEntity<>(service.update(id,userDto),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("name/{name}")
    private ResponseEntity<?> findByName(@PathVariable String name) throws Exception {
        return new ResponseEntity<>(service.findByName(name),HttpStatus.OK);
    }
}
