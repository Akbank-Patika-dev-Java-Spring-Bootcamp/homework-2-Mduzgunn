package com.md.hw2.controller.contract;

import com.md.hw2.dto.UserDto;
import com.md.hw2.dto.requests.CreateUserRequest;

import java.util.List;

public interface UserControllerContract {

    UserDto save(CreateUserRequest request);

    List<UserDto> findAll();

    void delete(Long id);
}
