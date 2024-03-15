package com.example.joboffers.domain.offer;

import lombok.Builder;

@Builder
 public record Offer(String id, String company, String position,  String salary, String offerUrl) {
}
