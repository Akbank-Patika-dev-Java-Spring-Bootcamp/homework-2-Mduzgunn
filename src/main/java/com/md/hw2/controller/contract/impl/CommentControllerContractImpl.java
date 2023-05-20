package com.md.hw2.controller.contract.impl;

import com.md.hw2.controller.contract.CommentControllerContract;
import com.md.hw2.controller.contract.UserControllerContract;
import com.md.hw2.dto.CommentDto;
import com.md.hw2.dto.UserDto;
import com.md.hw2.dto.requests.CreateCommentRequest;
import com.md.hw2.dto.requests.CreateUserRequest;
import com.md.hw2.dto.requests.DeleteUserRequest;
import com.md.hw2.dto.requests.UpdateCommentRequest;
import com.md.hw2.dto.requests.UpdateUserRequest;
import com.md.hw2.entity.Comment;
import com.md.hw2.entity.Product;
import com.md.hw2.entity.User;
import com.md.hw2.mapper.CommentMapper;
import com.md.hw2.mapper.UserMapper;
import com.md.hw2.service.CommentService;
import com.md.hw2.service.ProductService;
import com.md.hw2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CommentControllerContractImpl implements CommentControllerContract {

    private final CommentService commentService;
    private final ProductService productService;
    private final UserService userService;

    @Override
    public CommentDto save(CreateCommentRequest createCommentRequest) {
        Product product = productService.findByIdWithControl(createCommentRequest.productId());
        User user = userService.findByIdWithControl(createCommentRequest.userId());

        Comment  comment = CommentMapper.INSTANCE.createCommentRequestToComment(createCommentRequest);

        comment.setUser(user);
        comment.setProduct(product);

        comment = commentService.save(comment);
        return CommentMapper.INSTANCE.commentToCommentDto(comment);
    }

    @Override
    public CommentDto update(Long id, UpdateCommentRequest updateCommentRequest) {
        Comment comment = commentService.findByIdWithControl(id);
        comment.setMessage(updateCommentRequest.message());
        comment = commentService.save(comment);
        return CommentMapper.INSTANCE.commentToCommentDto(comment);
    }


    @Override
    public List<CommentDto> findAll() {
        List<Comment> commentList = commentService.findAll();
        return CommentMapper.INSTANCE.convertToCommentDtoList(commentList);
    }

    @Override
    public CommentDto findById(Long id) {
        Comment comment = commentService.findByIdWithControl(id);
        return CommentMapper.INSTANCE.commentToCommentDto(comment);
    }


    @Override
    public void delete(Long id) {
        commentService.delete(id);
    }

    @Override
    public List<CommentDto> findAllByProductId(Long id) {
       Product product = productService.findByIdWithControl(id);
       List<Comment> commentList = product.getComments();
       return CommentMapper.INSTANCE.convertToCommentDtoList(commentList);
    }

    @Override
    public List<CommentDto> findAllByUserId(Long id) {
        User user = userService.findByIdWithControl(id);
        List<Comment> commentList = user.getComments();
        return CommentMapper.INSTANCE.convertToCommentDtoList(commentList);
    }

}
