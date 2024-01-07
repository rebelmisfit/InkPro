package com.test.pictora.payloads;

import com.test.pictora.entities.Category;
import com.test.pictora.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class PostsDto {
    private Integer postId;
    private String title;
    private String content ;

private String imgName;
private Date addDate;
private CategoryDto category;
private UserDto user;


}
