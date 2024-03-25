package com.example.joboffers.domain.loginandregister;

import com.example.joboffers.domain.loginandregister.dto.RegisterResultDto;
import com.example.joboffers.domain.loginandregister.dto.UserRegisterDto;
import com.example.joboffers.domain.loginandregister.dto.UserResponseDto;
import lombok.AllArgsConstructor;

import java.util.UUID;


@AllArgsConstructor
public class LoginAndRegisterFacade {

    private final LoginAndRegisterRepository loginAndRegisterRepository;

    public UserResponseDto findByUsername(String username){
            return loginAndRegisterRepository.findByUsername(username)
                    .map(LoginAndRegisterMapper::mapFromUserToUserDto)
                    .orElseThrow(() -> new UserNotFoundException(username));
    }

    public RegisterResultDto register(UserRegisterDto userRegisterDto){
        final User user = User.builder()
                .username(userRegisterDto.username())
                .password(userRegisterDto.password())
                .build();

        User register = loginAndRegisterRepository.register(user);
        return RegisterResultDto.builder()
                .id(register.id())
                .created(true)
                .username(register.username())
                .build();
    }

}
