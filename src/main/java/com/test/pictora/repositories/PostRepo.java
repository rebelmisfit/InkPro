package com.test.pictora.repositories;

import com.test.pictora.entities.Category;
import com.test.pictora.entities.Posts;
import com.test.pictora.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepo extends JpaRepository<Posts,Integer> {
    List<Posts> findByUser(User user);
    List<Posts> findByCategory(Category category);
    List<Posts> findByTitleContaining(String title);

}
