package com.example.joboffers.domain.loginandregister;

import java.util.Optional;

public interface LoginAndRegisterRepository {

     Optional<User> findByUsername(String username);

    User register(User user);

}
