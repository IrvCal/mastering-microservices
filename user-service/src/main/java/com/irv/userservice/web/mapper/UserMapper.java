package com.irv.userservice.web.mapper;

import com.irv.userservice.domain.User;
import com.irv.userservice.web.model.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto user);
    List<User> usersDtoToUsers(List<UserDto> users);
    List<UserDto> usersToUsersDto(List<User> users);
}
