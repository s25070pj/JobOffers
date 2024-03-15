package com.example.joboffers.domain.offer.dto;

import lombok.Builder;

@Builder
public record OfferResponseDto(String id, String company, String position,  String salary, String offerUrl) {
}
