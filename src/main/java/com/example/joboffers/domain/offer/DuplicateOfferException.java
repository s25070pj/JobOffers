package com.example.joboffers.domain.offer;

import lombok.Getter;

import java.util.List;

@Getter
public class DuplicateOfferException extends RuntimeException{

    private final List<String> offerUrls;

    public DuplicateOfferException(String offerUrl) {
        super(String.format("Offer with offerUrl |%s| already exists ", offerUrl));
        this.offerUrls = List.of(offerUrl);
    }

    public DuplicateOfferException(String message, List<Offer> offers) {
        super(String.format("error" + message + offers.toString()));
        this.offerUrls = offers.stream().map(Offer::offerUrl).toList();
    }
}
