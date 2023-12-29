package com.test.pictora.payloads;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Integer id;
    @NotEmpty(message = "name cannot be empty")
    private String name;
    @Email(message = "email should be valid")

    private String email;
    @NotEmpty(message = "password cannot be null")

    private String password;
    @NotEmpty(message = "about cannot be null")
    private String about;
}
