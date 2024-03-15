package com.example.joboffers.domain.offer.dto;

import lombok.Builder;

@Builder
public record OfferCacheResponse(String title, String company, String salary, String offerUrl) {
}
