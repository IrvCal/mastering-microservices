package com.irv.userservice.web.mapper;

import com.irv.userservice.domain.User;
import com.irv.userservice.web.model.UserDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User userToUserDto(UserDto userDto);
    UserDto userDtoToUser(User user);
}
