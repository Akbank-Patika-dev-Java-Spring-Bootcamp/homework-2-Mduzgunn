package com.md.hw2.dto;

import com.md.hw2.enums.UserType;

import java.util.List;

public record ProductDto(Long id,
                      String name,
                      Integer price,
                      List<CommentDto> commentDtoList) {

}
