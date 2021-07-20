package com.crud.events.mapper;

import com.crud.events.domain.User;
import com.crud.events.domain.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    void mapToUserTest() {

        //given
        UserDto userDto = new UserDto(1L, "Test User");

        //when
        User user = userMapper.mapToUser(userDto);

        //then
        assertThat(user).isNotNull();
        assertThat(user.getUserId()).isEqualTo(1L);
        assertThat(user.getName()).isEqualTo("Test User");

    }

    @Test
    void mapToUserDtoTest() {

        //given
        User user = new User(1L, "Test User");

        //when
        UserDto userDto = userMapper.mapToUserDto(user);

        //then
        assertThat(userDto).isNotNull();
        assertThat(userDto.getUserId()).isEqualTo(1L);
        assertThat(userDto.getName()).isEqualTo("Test User");

    }

}