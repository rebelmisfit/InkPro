package com.test.pictora.services;

import com.test.pictora.entities.User;
import com.test.pictora.payloads.UserDto;

import java.util.List;

public interface UserService {

UserDto createUser(UserDto user);
UserDto updateUser(UserDto user, Integer userId);
UserDto getUserById(Integer id);
List<UserDto> getAllUsers();
void deleteUser(Integer id);
}
