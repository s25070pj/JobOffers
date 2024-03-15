package com.example.joboffers.domain.offer;

import com.example.joboffers.domain.offer.dto.OfferCacheResponse;

import java.util.List;

public interface OfferFetchable {
     List<OfferCacheResponse> fetchOffers();
}
