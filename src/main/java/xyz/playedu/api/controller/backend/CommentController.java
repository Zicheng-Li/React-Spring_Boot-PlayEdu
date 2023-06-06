package xyz.playedu.api.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.playedu.api.domain.Comment;
import xyz.playedu.api.mapper.CommentMapper;
import xyz.playedu.api.request.backend.CommentRequest;
import xyz.playedu.api.service.CommentService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/backend/v1/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentMapper commentMapper;

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Long id) {
        Comment comment = commentService.getCommentById(id);
        return ResponseEntity.ok(comment);
    }

    @PostMapping("/create")
    public Comment createComment(@RequestBody CommentRequest commentRequest) {
        Comment comment = new Comment();
        comment.setContent(commentRequest.getContent());
        comment.setPostId(commentRequest.getPostId());
        comment.setCreatedAt(LocalDateTime.now());  // Add this line
        comment.setUpdatedAt(LocalDateTime.now());
        commentMapper.insertComment(comment);
        return comment;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody CommentRequest commentRequest) {
        Comment comment = commentService.getCommentById(id);
        comment.setContent(commentRequest.getContent());
        comment.setUpdatedAt(LocalDateTime.now());  // Add this line
        comment.setUpdatedAt(LocalDateTime.now());
        commentMapper.updateComment(comment);
        Comment updatedComment = commentService.getCommentById(id);
        return ResponseEntity.ok(updatedComment);
    }

}
