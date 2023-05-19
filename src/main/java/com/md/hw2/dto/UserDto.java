package com.md.hw2.dto;

import com.md.hw2.enums.UserType;

import java.util.List;

public record UserDto(Long id,
                      String name,
                      String surname,
                      String phoneNumber,
                      String email,
                      UserType userType,
                      List<CommentDto> commentDtoList) {

}
