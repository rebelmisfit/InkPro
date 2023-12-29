package com.test.pictora.services.imp;


import com.test.pictora.entities.User;
import com.test.pictora.exceptions.ResourceNotFoundException;
import com.test.pictora.payloads.UserDto;
import com.test.pictora.repositories.UserRepo;
import com.test.pictora.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImp implements UserService {


    @Autowired

    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    public UserDto createUser(UserDto userDto){
        User user = this.dtoToUser(userDto);
        this.userRepo.save(user);
        User savedUser = this.userRepo.save(user);
        UserDto savedUserDto = this.userToDto(savedUser);
        return savedUserDto;
    }



    public UserDto updateUser(UserDto userDto, Integer userId){
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user","id",userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        this.userRepo.save(user);
     User updatedUser = this.userRepo.save(user);
     return this.userToDto(updatedUser);
    }
    public UserDto getUserById(Integer id){
        User user = this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("user","id",id));
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
     List<User> users = this.userRepo.findAll();
     List<UserDto> userDtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
     return userDtos;
    }

    @Override
    public void deleteUser(Integer id) {
User user = this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("user","id",id));
this.userRepo.delete(user);
    }
    public User dtoToUser(UserDto userDto){

        User user = this.modelMapper.map(userDto,User.class);
//        user.setId(userDto.getId());
//        user.setEmail(userDto.getEmail());
//        user.setName(userDto.getName());
//        user.setPassword(userDto.getPassword());
//        user.setAbout(userDto.getAbout());

        return user;
    }
    public UserDto userToDto(User user){
        UserDto userDto = this.modelMapper.map(user,UserDto.class  );
//        userDto.setId(user.getId());
//        userDto.setEmail(user.getEmail());
//        userDto.setName(user.getName());
//        userDto.setPassword(user.getPassword());
//        userDto.setAbout(user.getAbout());
        return userDto;
    }

}

