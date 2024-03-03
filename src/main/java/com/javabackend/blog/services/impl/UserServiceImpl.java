package com.javabackend.blog.services.impl;

import com.javabackend.blog.entities.User;
import com.javabackend.blog.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.javabackend.blog.payloads.UserDto;
import com.javabackend.blog.repositories.UserRepository;
import com.javabackend.blog.services.UserService;
import com.javabackend.blog.exceptions.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepository.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User"," id ", userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User updatedUser = this.userRepository.save(user);
        UserDto updatedUserDto = this.userToDto(updatedUser);
        return updatedUserDto;

    }

    @Override
    public UserDto getUserById(Integer id) {
        User user = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User"," id ", id));
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<User> userList =  this.userRepository.findAll();
        List<UserDto> userDtoList = userList.stream().map(user -> this.userToDto(user)).toList();
        return userDtoList;

    }

    @Override
    public void deleteUser(Integer id) {
        User user = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User"," id ", id));
        this.userRepository.delete(user);

    }

    public User dtoToUser(UserDto userDto){

       /* User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());*/

        User user = this.modelMapper.map(userDto, User.class);
        return user;
    }

    public UserDto userToDto(User user){
        /*UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());*/
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
