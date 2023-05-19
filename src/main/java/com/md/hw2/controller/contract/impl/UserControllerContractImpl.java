package com.md.hw2.controller.contract.impl;

import com.md.hw2.controller.contract.UserControllerContract;
import com.md.hw2.dto.UserDto;
import com.md.hw2.dto.requests.CreateUserRequest;
import com.md.hw2.dto.requests.UpdateUserRequest;
import com.md.hw2.entity.User;
import com.md.hw2.exception.UserErrorMessage;
import com.md.hw2.mapper.UserMapper;
import com.md.hw2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserControllerContractImpl implements UserControllerContract {

    private final UserService userService;

    @Override
    public UserDto save(CreateUserRequest createUserRequest) {
        User user = UserMapper.INSTANCE.createUserRequestToUser(createUserRequest);
        user = userService.save(user);
        return UserMapper.INSTANCE.userToUserDto(user);
    }

    @Override
    public UserDto update(Long id, UpdateUserRequest updateUserRequest) {
        User user = UserMapper.INSTANCE.updateUserRequestToUser(id, updateUserRequest);
//        if (userDto == null) {
//            // TODO hata mesajı dön
//            return null;
//        }
        user = userService.save(user);
        return UserMapper.INSTANCE.userToUserDto(null);
    }


    @Override
    public List<UserDto> findAll() {
        List<User> userList = userService.findAll();
        return UserMapper.INSTANCE.convertToUserDtoList(userList);
    }

    @Override
    public UserDto findById(Long id) {
        User user = userService.findByIdWithControl(id);
        return UserMapper.INSTANCE.userToUserDto(user);
    }

    @Override
    public void delete(Long id) {
        userService.delete(id);
    }
}
