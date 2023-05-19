package com.md.hw2.controller.contract;

import com.md.hw2.dto.UserDto;
import com.md.hw2.dto.requests.CreateUserRequest;
import com.md.hw2.dto.requests.UpdateUserRequest;

import java.util.List;

public interface UserControllerContract {

    UserDto save(CreateUserRequest createUserRequest);

    UserDto update(Long id, UpdateUserRequest updateUserRequest);

    List<UserDto> findAll();

    UserDto findById(Long id);

    void delete(Long id);
}
