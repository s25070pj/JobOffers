package com.example.joboffers.domain.offer;


import com.example.joboffers.domain.offer.dto.OfferRequestDto;
import com.example.joboffers.domain.offer.dto.OfferResponseDto;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public class OfferFacade {

    private final OfferRepository offerRepository;


    public OfferResponseDto saveOffer(OfferRequestDto offerRequestDto){
            Offer offer = OfferMapper.mapOfferDtoToOffer(offerRequestDto);
            OfferResponseDto offerResponseDto = OfferMapper.mapOfferToOfferDto(offer);
            offerRepository.saveOffer(offer);
            return offerResponseDto;
    }

    public OfferResponseDto findOfferById(String id){

        return offerRepository.findOfferById(id)
                .map(OfferMapper::mapOfferToOfferDto)
                .orElseThrow(() -> new OfferNotFoundException(id));
    }

    public List<OfferResponseDto> findAllOffers(){

        return offerRepository.findAllOffers()
                .stream()
                .map(OfferMapper::mapOfferToOfferDto)
                .collect(Collectors.toList());
    }

    public List<OfferResponseDto> fetchAllOffersAndSaveAllIfNotExistsInBase(){

        return null;
    }

     public boolean existsById(String id){

     }


}
