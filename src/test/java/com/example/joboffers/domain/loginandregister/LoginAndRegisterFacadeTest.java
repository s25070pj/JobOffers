package com.example.joboffers.domain.loginandregister;

import com.example.joboffers.domain.loginandregister.dto.RegisterResultDto;
import com.example.joboffers.domain.loginandregister.dto.UserRegisterDto;
import com.example.joboffers.domain.loginandregister.dto.UserResponseDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class LoginAndRegisterFacadeTest {

    LoginAndRegisterFacade loginAndRegisterFacade = new LoginAndRegisterFacade(
            new LoginAndRegisterRepositoryTestImplementation()
    );

    @Test
    public void should_register_user(){
        //given
        UserRegisterDto userRegisterDto = new UserRegisterDto("adi", "123");

        //when
        RegisterResultDto register = loginAndRegisterFacade.register(userRegisterDto);

        //then

        assertThat(register.created()).isTrue();
        assertThat(register.username()).isEqualTo("adi");
    }

    @Test
    public void should_find_user_by_username(){
        //given
        UserRegisterDto userRegisterDto = new UserRegisterDto("adi", "123");
        RegisterResultDto register = loginAndRegisterFacade.register(userRegisterDto);
        //when
        UserResponseDto searchedUser = loginAndRegisterFacade.findByUsername(register.username());
        //then
        assertThat(searchedUser).isEqualTo(new UserResponseDto(register.id(), "adi", "123"));
    }

    @Test
    public void should_throw_exception_when_user_not_found(){
        //given
        String username = "adi";
        //when
        Throwable throwable = catchThrowable(() -> loginAndRegisterFacade.findByUsername(username));
        //then
        assertThat(throwable).isInstanceOf(UserNotFoundException.class).hasMessage("User with username " + username + " not found");
    }

}
