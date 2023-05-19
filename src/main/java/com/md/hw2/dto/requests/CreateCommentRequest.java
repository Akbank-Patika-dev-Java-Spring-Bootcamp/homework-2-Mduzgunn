package com.md.hw2.dto.requests;

public record CreateCommentRequest(String message,
                                   Long productId,
                                   Long userId) {

}
