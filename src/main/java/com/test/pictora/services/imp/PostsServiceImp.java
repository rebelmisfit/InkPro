package com.test.pictora.services.imp;

import com.test.pictora.entities.Category;
import com.test.pictora.entities.Posts;
import com.test.pictora.entities.User;
import com.test.pictora.exceptions.ResourceNotFoundException;
import com.test.pictora.payloads.PostsDto;
import com.test.pictora.repositories.CategoryRepo;
import com.test.pictora.repositories.PostRepo;
import com.test.pictora.repositories.UserRepo;
import com.test.pictora.services.PostsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostsServiceImp implements PostsService {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public PostsDto createPost(PostsDto postsDto, Integer userId, Integer categoryId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user","id",userId));
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category", "id", categoryId));

        Posts post = this.modelMapper.map(postsDto, Posts.class);
       post.setImgName("default.png");
       post.setAddDate(new Date());
         post.setUser(user);
            post.setCategory(category);
            this.postRepo.save(post);
            Posts newPost = this.postRepo.save(post);
            return this.modelMapper.map(newPost, PostsDto.class);
    }

    @Override
    public PostsDto updatePost(PostsDto posts, Integer postId) {
        Posts post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post","id",postId));
        post.setTitle(posts.getTitle());
        post.setContent(posts.getContent());
        post.setImgName(posts.getImgName());


        Posts updatedPost = this.postRepo.save(post);
        return this.modelMapper.map(updatedPost, PostsDto.class);

    }

    @Override
    public void deletePost(Integer postId) {
        this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post","id",postId));
        this.postRepo.deleteById(postId);
    }

    @Override
    public List<PostsDto> getAllPosts() {
        List<Posts> allPosts = this.postRepo.findAll();
        List<PostsDto> postDtos = allPosts.stream().map(post->this.modelMapper.map(post, PostsDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostsDto getPostsById(Integer postId) {
        Posts post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post","id",postId));
        return this.modelMapper.map(post, PostsDto.class);
    }

    @Override
    public List<PostsDto> getPostsByCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category","id",categoryId));
    List<Posts> posts = this.postRepo.findByCategory(cat);
    List<PostsDto>postDtos = posts.stream().map((post)->this.modelMapper.map(posts, PostsDto.class)).collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public List<PostsDto> getPostsByUser(Integer userId) {

        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user","id",userId));
        List<Posts> posts = this.postRepo.findByUser(user);
        List<PostsDto> postDtos = posts.stream().map(post->this.modelMapper.map(post, PostsDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<Posts> searchPosts(String keywords) {
        return null;
    }
}
