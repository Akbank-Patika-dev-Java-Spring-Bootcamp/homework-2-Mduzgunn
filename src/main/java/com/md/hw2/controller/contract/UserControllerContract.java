package com.md.hw2.controller.contract;

import com.md.hw2.dto.UserDto;
import com.md.hw2.dto.requests.CreateUserRequest;
import com.md.hw2.dto.requests.DeleteUserRequest;
import com.md.hw2.dto.requests.UpdateUserRequest;

import java.util.List;

public interface UserControllerContract {

    UserDto save(CreateUserRequest createUserRequest);

    UserDto update(Long id, UpdateUserRequest updateUserRequest);

    UserDto findByName (String name);

    List<UserDto> findAll();

    UserDto findById(Long id);

    boolean delete(DeleteUserRequest deleteUserRequest);
}
