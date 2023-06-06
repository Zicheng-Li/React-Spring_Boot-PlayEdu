package xyz.playedu.api.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.playedu.api.domain.Post;
import xyz.playedu.api.mapper.PostMapper;
import xyz.playedu.api.request.backend.PostRequest;
import xyz.playedu.api.service.PostService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/backend/v1/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostMapper postMapper;

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Long id) {
        Post post = postService.getPostById(id);
        if (post != null) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public Post createPost(@RequestBody PostRequest postRequest) {
        Post post = new Post();
        post.setContent(postRequest.getContent());
        post.setTitle(postRequest.getTitle());
        post.setCreatedAt(LocalDateTime.now());  // Add this line
        post.setUpdatedAt(LocalDateTime.now());
        postMapper.insertPost(post);
        return post;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody PostRequest postRequest) {
        Post post = postService.getPostById(id);
        post.setContent(postRequest.getContent());
        post.setTitle(postRequest.getTitle());
        post.setUpdatedAt(LocalDateTime.now());  // Add this line
        post.setUpdatedAt(LocalDateTime.now());
        postMapper.updatePost(post);
        Post updatedPost = postService.getPostById(id);
        return ResponseEntity.ok(updatedPost);
    }
}
