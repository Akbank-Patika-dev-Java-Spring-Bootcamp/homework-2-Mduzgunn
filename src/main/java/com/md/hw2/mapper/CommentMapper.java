package com.md.hw2.mapper;

import com.md.hw2.dto.CommentDto;
import com.md.hw2.dto.requests.CreateCommentRequest;
import com.md.hw2.entity.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    Comment createCommentRequestToComment(CreateCommentRequest createCommentRequest);

    CommentDto commentToCommentDto(Comment comment);

    List<CommentDto> convertToCommentDtoList(List<Comment> commentList);
}
