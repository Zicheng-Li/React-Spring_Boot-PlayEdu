package xyz.playedu.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.playedu.api.domain.Post;

public interface PostService extends IService<Post> {

    Post createPost(String title, String content);

    Post updatePost(Post post, String title, String content);

    Post getPostById(Long id);

}

