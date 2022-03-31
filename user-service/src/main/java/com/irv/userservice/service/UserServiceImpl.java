package com.irv.userservice.service;

import com.irv.userservice.domain.User;
import com.irv.userservice.exceptions.UserNotFoundException;
import com.irv.userservice.repository.UserRepository;
import com.irv.userservice.web.mapper.UserMapper;
import com.irv.userservice.web.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserDto add(UserDto userDto) throws Exception {
        return mapper.userToUserDto(repository.save(mapper.userDtoToUser(userDto)));
    }

    @Override
    public UserDto update(Long id, UserDto userDto) throws Exception {
        return mapper.userToUserDto(
                repository.save(
                        repository.findById(id).map(user -> {
                            user.setName(userDto.getName());
                            user.setLast_name(userDto.getLast_name());
                            user.setPhone(userDto.getPhone());
                            return user;
                        }).orElseThrow(UserNotFoundException::new)));
    }

    @Override
    public void delete(Long id) throws Exception {
        repository.delete(getOptionalUser(id));
    }

    @Override
    public UserDto findById(Long id) throws Exception {
        return repository.findById(id).map(mapper::userToUserDto).orElseThrow(UserNotFoundException::new);
//        return mapper.userToUserDto(getOptionalUser(id));
    }

    @Override
    public Collection<UserDto> findAll() throws Exception {
        return mapper.usersToUsersDto(repository.findAll());
    }
    @Override
    public List<UserDto> findByName(String name) throws Exception {
        return mapper.usersToUsersDto(repository.findByName(name).orElseThrow(UserNotFoundException::new));
    }


    private User getOptionalUser(Long id) throws UserNotFoundException {
        return repository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}
