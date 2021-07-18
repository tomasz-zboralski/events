package com.crud.events.mapper;

import com.crud.events.domain.User;
import com.crud.events.domain.UserDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
@Service
public interface UserMapper {
    User mapToUser(UserDto userDto);
    UserDto mapToUserDto(User user);


}
