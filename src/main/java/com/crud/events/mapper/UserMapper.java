package com.crud.events.mapper;

import com.crud.events.domain.User;
import com.crud.events.domain.UserDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Mapper(componentModel = "spring", uses = EventMapper.class)
@Service
public interface UserMapper {
    User mapToUser(UserDto userDto);
    UserDto mapToUserDto(User user);
    Set<User> mapToUserSet(Set<UserDto> userDtoSet);
    Set<UserDto> mapToUserDtoSet(Set<User> userSet);


}
