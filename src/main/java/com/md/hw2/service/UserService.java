package com.md.hw2.service;

import com.md.hw2.base.service.BaseService;
import com.md.hw2.entity.User;
import com.md.hw2.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, UserRepository> {

    public UserService(UserRepository repository) {
        super(repository);
    }

}
