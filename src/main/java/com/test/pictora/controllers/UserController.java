package com.test.pictora.controllers;

import com.test.pictora.payloads.UserDto;
import com.test.pictora.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

@Autowired
    private UserService userService;
//create - post reqs
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
    {
     UserDto createUserDto = this.userService.createUser(userDto);
     return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }
    // update - put reqs
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer userId)
    {
    UserDto updateduser = this.userService.updateUser(userDto,userId);

    return ResponseEntity.ok(updateduser);
    }
    // delete - delete reqs
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Integer userId)
    {
        this.userService.deleteUser(userId);
        System.out.println("deleted user successfully ");
    }
//get - get reqs
    @GetMapping("/")
 public ResponseEntity<List<UserDto>> getAllUsers()
 {
 return ResponseEntity.ok(this.userService.getAllUsers());
 }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId)
    {
        UserDto userDto = this.userService.getUserById(userId);
        return ResponseEntity.ok(userDto);
 }

}
