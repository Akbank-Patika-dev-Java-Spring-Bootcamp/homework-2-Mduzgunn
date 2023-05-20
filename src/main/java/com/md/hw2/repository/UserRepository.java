package com.md.hw2.repository;

import com.md.hw2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(
            "select user from User user where user.name = :username "
    )
    User findByUsername(String username);

    @Query(
            "select user from User user where user.phoneNumber = :phoneNumber "
    )
    User findByPhoneNumber(String phoneNumber);
}
