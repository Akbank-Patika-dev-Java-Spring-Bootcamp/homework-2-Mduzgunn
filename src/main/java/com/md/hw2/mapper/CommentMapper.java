package com.md.hw2.mapper;

import com.md.hw2.dto.CommentDto;
import com.md.hw2.dto.requests.CreateCommentRequest;
import com.md.hw2.dto.requests.UpdateCommentRequest;
import com.md.hw2.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    Comment createCommentRequestToComment(CreateCommentRequest createCommentRequest);

    CommentDto commentToCommentDto(Comment comment);

    List<CommentDto> convertToCommentDtoList(List<Comment> commentList);

}
