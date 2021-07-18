package com.crud.events.controller;

import com.crud.events.domain.User;
import com.crud.events.domain.UserDto;
import com.crud.events.exception.UserNotFoundException;
import com.crud.events.mapper.UserMapper;
import com.crud.events.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public Set<UserDto> getAllUsers() {
        return userMapper.mapToUserDtoSet(userService.getAllUsers());
    }

    @GetMapping(value = "/{userId}")
    public UserDto getUser(@PathVariable Long userId) {
        return userMapper.mapToUserDto(userService.findUser(userId).orElseThrow(UserNotFoundException::new));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public UserDto createUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        return userMapper.mapToUserDto(userService.createUser(user));
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public UserDto updateUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        return userMapper.mapToUserDto(userService.createUser(user));
    }

    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

}
