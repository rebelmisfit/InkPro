package com.test.pictora.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    @Column(name = "post_title", length = 100, nullable = false)
    private String title;
    private String content;
    private String imgName;
    private Date addDate;

@ManyToOne
@JoinColumn(name = "category_id", nullable = false)
    private Category category;
@ManyToOne
private User user ;




}
