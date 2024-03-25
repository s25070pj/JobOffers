package com.example.joboffers.domain.loginandregister.dto;

import lombok.Builder;

@Builder
public record UserRegisterDto(String username,
                              String password) {
}
