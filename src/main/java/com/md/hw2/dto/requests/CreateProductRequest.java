package com.md.hw2.dto.requests;

import com.md.hw2.dto.CommentDto;
import com.md.hw2.enums.UserType;

import java.util.List;


public record CreateProductRequest(String name,
                                   Integer price) {

}
