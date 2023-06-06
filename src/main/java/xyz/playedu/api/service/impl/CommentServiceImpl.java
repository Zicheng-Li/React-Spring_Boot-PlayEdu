package xyz.playedu.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.playedu.api.domain.Comment;
import xyz.playedu.api.mapper.CommentMapper;
import xyz.playedu.api.service.CommentService;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Override
    public Comment createComment(String content, Long postId) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setPostId(postId);
        this.save(comment);
        return comment;
    }

    @Override
    public void updateComment(Comment comment, String content) {
        comment.setContent(content);
        this.updateById(comment);
    }

    @Override
    public Comment getCommentById(Long id) {
        return this.getById(id);
    }
}
