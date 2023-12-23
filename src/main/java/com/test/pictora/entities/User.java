package com.test.pictora.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
@Column(name ="username", nullable = false)
    private String name;
    private String email;
    private String password;
    private String about;
}
