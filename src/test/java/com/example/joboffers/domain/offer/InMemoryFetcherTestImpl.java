package com.example.joboffers.domain.offer;


import com.example.joboffers.domain.offer.dto.JobOfferResponse;

import java.util.List;

public class InMemoryFetcherTestImpl implements OfferFetchable {

    List<JobOfferResponse> listOfOffers;

    InMemoryFetcherTestImpl(List<JobOfferResponse> listOfOffers) {
        this.listOfOffers = listOfOffers;
    }

    @Override
    public List<JobOfferResponse> fetchOffers() {
        return listOfOffers;
    }
}
