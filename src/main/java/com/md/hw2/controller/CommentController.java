package com.md.hw2.controller;

import com.md.hw2.base.RestResponse;
import com.md.hw2.controller.contract.CommentControllerContract;
import com.md.hw2.controller.contract.UserControllerContract;
import com.md.hw2.dto.CommentDto;
import com.md.hw2.dto.requests.CreateCommentRequest;
import com.md.hw2.dto.requests.UpdateCommentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentControllerContract commentControllerContract;

    @PostMapping
    public ResponseEntity<RestResponse<CommentDto>> save(@RequestBody CreateCommentRequest createCommentRequest) {
        var commentDto = commentControllerContract.save(createCommentRequest);
        return ResponseEntity.ok(RestResponse.of(commentDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestResponse<CommentDto>> update(@PathVariable Long id, @RequestBody UpdateCommentRequest updateCommentRequest) {
        var commentDTO = commentControllerContract.update(id, updateCommentRequest);
        return ResponseEntity.ok(RestResponse.of(commentDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<CommentDto>> findById(@PathVariable Long id) {
        var commentDto = commentControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(commentDto));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<RestResponse<List<CommentDto>>> findAllByProductId(@PathVariable Long id){
        List<CommentDto> comments = commentControllerContract.findAllByProductId(id);
        if (comments == null || comments.size() == 0) {
            return ResponseEntity.ok(RestResponse.errorMessage(String.format("%s numaralı ürüne ait henüz bir yorum yazmamıştır", id)));
        }
        return ResponseEntity.ok(RestResponse.of(comments));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<RestResponse<List<CommentDto>>> findAllByUserId(@PathVariable Long id){
        List<CommentDto> comments = commentControllerContract.findAllByUserId(id);
        if (comments == null || comments.size() == 0) {
            return ResponseEntity.ok(RestResponse.errorMessage(String.format("%s numaralı kullanıcı henüz bir yorum yazmamıştır", id)));
        }
        return ResponseEntity.ok(RestResponse.of(comments));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<CommentDto>>> findAll() {
        var commentDTOList = commentControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(commentDTOList));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<String>> delete(@PathVariable Long id) {
        commentControllerContract.delete(id);
        return ResponseEntity.ok(RestResponse.of("Deleted by " + id));
    }

}
