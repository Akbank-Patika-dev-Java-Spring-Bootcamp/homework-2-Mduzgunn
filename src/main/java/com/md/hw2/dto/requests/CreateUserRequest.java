package com.md.hw2.dto.requests;


import com.md.hw2.enums.UserType;


public record CreateUserRequest(String name,
                                String surname,
                                String password,
                                String phoneNumber,
                                UserType userType) {

}
