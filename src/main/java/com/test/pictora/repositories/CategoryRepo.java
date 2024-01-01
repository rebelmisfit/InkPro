package com.test.pictora.repositories;

import com.test.pictora.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
