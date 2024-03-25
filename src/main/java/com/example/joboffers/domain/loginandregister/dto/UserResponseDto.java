package com.example.joboffers.domain.loginandregister.dto;

import lombok.Builder;

@Builder
public record UserResponseDto(String id,
                              String username,
                              String password) {
}
