package com.example.joboffers.domain.loginandregister;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.*;

class LoginAndRegisterRepositoryTestImplementation implements LoginAndRegisterRepository{

    Map<String, User> database = new ConcurrentHashMap<>();

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(database.get(username));
    }

    @Override
    public User register(User user) {
        UUID id = UUID.randomUUID();
        User testUser = new User(id.toString(), user.username(), user.password());

        database.put(user.username(), testUser);
        return testUser;
    }
}