package com.test.pictora.services;

import com.test.pictora.entities.Posts;
import com.test.pictora.payloads.PostsDto;

import java.util.List;

public interface PostsService {
    //create
    PostsDto createPost(PostsDto posts, Integer userId, Integer categoryId);
    //update
    PostsDto updatePost(PostsDto posts, Integer postId);
    //delete
    void deletePost(Integer postId);
    //get all posts
    List<PostsDto> getAllPosts();
    //get single post by id
    PostsDto getPostsById(Integer postId);
    //get posts by category
    List<PostsDto> getPostsByCategory(Integer categoryId);
    //get posts by user
    List<PostsDto> getPostsByUser(Integer userId);
    //search posts
    List<Posts> searchPosts(String keywords);

}
