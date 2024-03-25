package com.example.joboffers.domain.loginandregister;

import com.example.joboffers.domain.loginandregister.dto.UserResponseDto;

public class LoginAndRegisterMapper {

    public static UserResponseDto mapFromUserToUserDto(User user){
        return UserResponseDto.builder()
                .id(user.id())
                .username(user.username())
                .password(user.password())
                .build();
    }

    public static User mapFromUserDtoToUser(UserResponseDto userResponseDto){
        return User.builder()
                .id(userResponseDto.id())
                .username(userResponseDto.username())
                .password(userResponseDto.password())
                .build();
    }


}
