package com.md.hw2.controller.contract;

import com.md.hw2.dto.CommentDto;
import com.md.hw2.dto.requests.CreateCommentRequest;
import com.md.hw2.dto.requests.UpdateCommentRequest;

import java.util.List;

public interface CommentControllerContract {

    CommentDto save(CreateCommentRequest createCommentRequest);

    CommentDto update(Long id, UpdateCommentRequest updateCommentRequest);

    List<CommentDto> findAll();

    CommentDto findById(Long id);

    List<CommentDto> findAllByProductId(Long id);

    List<CommentDto> findAllByUserId(Long id);

    void delete(Long id);
}
