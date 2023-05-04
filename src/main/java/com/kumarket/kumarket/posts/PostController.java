package com.kumarket.kumarket.posts;

import com.kumarket.kumarket.posts.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("")
    public List<PostDto> loadAllPosts(){
        return postService.findAllPosts();
    }

    @GetMapping("/{id}")
    public PostDto loadPost(@PathVariable("id") Long id){
        return postService.findPostById(id);
    }

    @PostMapping("")
    public PostDto uploadPost(@RequestBody PostDto postDto){
        return postService.createPost(postDto);
    }

    @PatchMapping("/{id}")
    public PostDto editPost(@PathVariable("id") Long id, @RequestBody PostDto postDto){
        return postService.updatePost(id, postDto);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") Long id){
        postService.deletePost(id);
    }

}
