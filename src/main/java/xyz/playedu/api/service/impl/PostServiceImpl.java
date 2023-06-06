package xyz.playedu.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.playedu.api.domain.Post;
import xyz.playedu.api.mapper.PostMapper;
import xyz.playedu.api.service.PostService;

@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

    @Override
    public Post createPost(String title, String content) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        this.save(post);
        return post;
    }

    @Override
    public Post updatePost(Post post, String title, String content) {
        post.setTitle(title);
        post.setContent(content);
        this.updateById(post);
        return post;  // 返回更新后的post对象
    }
    @Override
    public Post getPostById(Long id) {
        return this.getById(id);
    }


}
