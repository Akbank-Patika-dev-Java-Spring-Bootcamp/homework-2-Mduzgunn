package com.md.hw2.controller.contract.impl;

import com.md.hw2.base.service.BaseService;
import com.md.hw2.controller.contract.UserControllerContract;
import com.md.hw2.dto.UserDto;
import com.md.hw2.dto.requests.CreateUserRequest;
import com.md.hw2.entity.User;
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
    public UserDto save(CreateUserRequest request) {
        User user = UserMapper.INSTANCE.convertToUser(request);
        user = userService.save(user);
        return UserMapper.INSTANCE.convertToUserDto(user);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> userList = userService.findAll();
        return UserMapper.INSTANCE.convertToUserDtoList(userList);
    }

    @Override
    public void delete(Long id) {
        userService.delete(id);
    }
}
