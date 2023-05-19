package com.md.hw2.service;

import com.md.hw2.base.service.BaseService;
import com.md.hw2.dto.CommentDto;
import com.md.hw2.dto.requests.CreateCommentRequest;
import com.md.hw2.dto.requests.UpdateCommentRequest;
import com.md.hw2.entity.Comment;
import com.md.hw2.mapper.CommentMapper;
import com.md.hw2.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService extends BaseService<Comment, CommentRepository> {

    private final CommentMapper commentMapper;
    public CommentService(CommentRepository repository, CommentMapper commentMapper) {
        super(repository);
        this.commentMapper = commentMapper;
    }
    public CommentDto getCommentById(Long id) {
        return commentMapper.commentToCommentDto(this.findByIdWithControl(id));
    }

    public List<CommentDto> getAllCommentDtoList() {
        return commentMapper.convertToCommentDtoList(this.findAll());
    }

    public CommentDto createComment(CreateCommentRequest createCommentRequest) {
        Comment comment = commentMapper.createCommentRequestToComment(createCommentRequest);
        return commentMapper.commentToCommentDto(this.save(comment));
    }

    public CommentDto updateComment(Long id, UpdateCommentRequest updateCommentRequest) {
        Comment comment = this.findByIdWithControl(id);
        comment.setMessage(updateCommentRequest.message());

        return commentMapper.commentToCommentDto(this.save(comment));
    }

    public String deleteCommentById(Long id) {
        getCommentById(id);
        this.delete(id);
        return "Comment deleted successfully with id " + id;
    }


}
