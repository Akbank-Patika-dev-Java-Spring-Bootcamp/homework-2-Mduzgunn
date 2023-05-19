package com.md.hw2.mapper;

import com.md.hw2.dto.UserDto;
import com.md.hw2.dto.requests.CreateUserRequest;
import com.md.hw2.dto.requests.UpdateUserRequest;
import com.md.hw2.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User createUserRequestToUser(CreateUserRequest createUserRequest);
    User updateUserRequestToUser(Long id, UpdateUserRequest updateUserRequest);

    UserDto userToUserDto(User user);

    List<UserDto> convertToUserDtoList(List<User> userList);
}
