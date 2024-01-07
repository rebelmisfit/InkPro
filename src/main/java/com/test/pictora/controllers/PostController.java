package com.test.pictora.controllers;

import com.test.pictora.entities.Posts;
import com.test.pictora.payloads.ApiResponse;
import com.test.pictora.payloads.PostsDto;
import com.test.pictora.services.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")

public class PostController {
    @Autowired
    private PostsService postsService;
    //create

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostsDto> createPost(@RequestBody PostsDto postDto, @PathVariable Integer userId, @PathVariable
                                               Integer categoryId){

      PostsDto createPost = this.postsService.createPost(postDto, userId, categoryId);
      return new ResponseEntity<PostsDto>(createPost, HttpStatus.CREATED);
    }

    //get by user
    @GetMapping("/user/{userID}/posts")
    public ResponseEntity<List<PostsDto>> getPostByUser(@PathVariable Integer userID)
    {
       List<PostsDto> posts = this.postsService.getPostsByUser(userID);
       return new ResponseEntity<List<PostsDto>>(posts, HttpStatus.OK);
    }

    //get  by category
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostsDto>> getPostByCategory(@PathVariable Integer categoryId)
    {
        List<PostsDto> posts = this.postsService.getPostsByCategory(categoryId);
        return new ResponseEntity<List<PostsDto>>(posts, HttpStatus.OK);
    }
    // get all posts
    @GetMapping("/posts")
    public ResponseEntity<List <PostsDto>> getAllPosts()
    {
        List<PostsDto> allPost = this.postsService.getAllPosts();
        return new ResponseEntity<List<PostsDto>>(allPost, HttpStatus.OK);
    }
    //get single post
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostsDto> getPostById(@PathVariable Integer postId)
    {
        PostsDto post = this.postsService.getPostsById(postId);
        return new ResponseEntity<PostsDto>(post, HttpStatus.OK);
    }
    @DeleteMapping("/posts/{postId}")
    //delete post
    public ApiResponse deletePost(@PathVariable Integer postId)
    {
        this.postsService.deletePost(postId);
        return new ApiResponse("post is deleted successfully", true);
    }

    //updated post
    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostsDto> updatePost (@RequestBody PostsDto postsDto, @PathVariable Integer postId)
    {
       this.postsService.updatePost(postsDto, postId);
         return new ResponseEntity<PostsDto>(postsDto, HttpStatus.OK);
    }

}

