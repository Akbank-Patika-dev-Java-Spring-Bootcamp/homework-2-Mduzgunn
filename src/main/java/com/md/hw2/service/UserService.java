package com.md.hw2.service;

import com.md.hw2.base.service.BaseService;
import com.md.hw2.dto.requests.DeleteUserRequest;
import com.md.hw2.entity.User;
import com.md.hw2.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, UserRepository> {
    public UserService(UserRepository repository) {
        super(repository);
    }

    public User getUserByName(String name) {
        return getRepository().findByUsername(name);
    }

    public User getUserByNumber(String number) {
        return getRepository().findByPhoneNumber(number);
    }

    public boolean deleteUserByPhoneAndName(DeleteUserRequest deleteUserRequest) {

        User user = getRepository().findByUsername(deleteUserRequest.name());
            if (user.getPhoneNumber().equals(deleteUserRequest.phoneNumber())) {
                getRepository().deleteById(user.getId());
                return true;
            } else {
                return false;
            }

    }

}
