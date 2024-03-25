package com.example.joboffers.domain.loginandregister.dto;

import lombok.Builder;

@Builder
public record RegisterResultDto(String id, boolean created, String username) {
}
