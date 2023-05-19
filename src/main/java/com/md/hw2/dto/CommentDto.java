package com.md.hw2.dto;


public record CommentDto(Long id,
                         String message,
                         ProductDto productDto,
                         UserDto userDto) {

}
