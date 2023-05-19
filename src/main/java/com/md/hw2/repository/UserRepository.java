package com.md.hw2.repository;

import com.md.hw2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query(
//            "select user from User user where user.name = :username "
//    )
//    User findByUsername(String username);

//    User findByNameAndSurname(String name, String surname);
//
//    List<User> findAllByIdBetween(Long first, Long last);
//
//    List<User> findAllByIdGreaterThan(Long id);
//
//    List<User> findAllByIdGreaterThanEqual(Long id);
}
