package com.example.joboffers.domain.offer;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class OfferFetcher {

    private final OfferFetchable offerFetchable;
    private final OfferRepository offerRepository;

    List<Offer> fetchAllOffersAndSaveAllIfNotExistsInBase(){
        List<Offer> offers = fetchOffers();
        List<Offer> offersAfterFiltering = filterNotExistingOffers(offers);
        try{
            return offerRepository.saveAllOffers(offersAfterFiltering);
        }catch (DuplicateOfferException duplicateOfferException){
            throw new OfferSavingException(duplicateOfferException.getMessage(), offers);
        }


    }

    private List<Offer> filterNotExistingOffers(List<Offer> offers){

        return offers.stream()
                .filter(offer -> !offer.offerUrl().isEmpty())
                .filter(offer -> !offerRepository.existsByOfferUrl(offer.offerUrl()))
                .collect(Collectors.toList());

    }


    private List<Offer> fetchOffers(){
        return offerFetchable.fetchOffers()
                .stream()
                .map(OfferMapper::mapOfferCacheResponseToOffer)
                .collect(Collectors.toList());
    }
}
