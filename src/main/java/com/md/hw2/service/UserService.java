package com.md.hw2.service;

import com.md.hw2.base.service.BaseService;
import com.md.hw2.dto.UserDto;
import com.md.hw2.dto.requests.CreateUserRequest;
import com.md.hw2.dto.requests.UpdateUserRequest;
import com.md.hw2.entity.User;
import com.md.hw2.mapper.UserMapper;
import com.md.hw2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends BaseService<User, UserRepository> {

    private final UserMapper userMapper;
    public UserService(UserRepository repository, UserMapper userMapper) {
        super(repository);
        this.userMapper = userMapper;
    }

    public UserDto getUserById(Long id) {
        return userMapper.userToUserDto(this.findByIdWithControl(id));
    }

    public List<UserDto> getAllUserDtoList() {
        return userMapper.convertToUserDtoList(this.findAll());
    }

    public UserDto createUser(CreateUserRequest createUserRequest) {
        User user = userMapper.createUserRequestToUser(createUserRequest);
        return userMapper.userToUserDto(this.save(user));
    }

    public UserDto updateUser(Long id, UpdateUserRequest updateUserRequest) {
        User user = this.findByIdWithControl(id);
        user.setPhoneNumber(updateUserRequest.phoneNumber());

        return userMapper.userToUserDto(this.save(user));
    }

    public String deleteUserById(Long id) {
        getUserById(id);
        this.delete(id);
        return "User deleted successfully with id " + id;
    }


}
