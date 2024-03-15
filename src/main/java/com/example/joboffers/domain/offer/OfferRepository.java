package com.example.joboffers.domain.offer;

import java.util.List;
import java.util.Optional;
public interface OfferRepository {

    Offer saveOffer(Offer offer);

    List<Offer> saveAllOffers(List<Offer> offersToSave);

    Optional<Offer> findOfferById(String id);

    Optional<Offer> findOfferByUrl(String offerUrl);

    List<Offer> findAllOffers();

    boolean existsById(String id);

    boolean existsByOfferUrl(String url);

}
