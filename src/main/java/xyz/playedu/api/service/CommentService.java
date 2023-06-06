package xyz.playedu.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.playedu.api.domain.Comment;

public interface CommentService extends IService<Comment> {

    Comment createComment(String content, Long postId);

    void updateComment(Comment comment, String content);

    Comment getCommentById(Long id);

}

