package com.example.joboffers.domain.offer;

import com.example.joboffers.domain.offer.dto.OfferCacheResponse;
import com.example.joboffers.domain.offer.dto.OfferRequestDto;
import com.example.joboffers.domain.offer.dto.OfferResponseDto;

public class OfferMapper {
   static OfferResponseDto mapOfferToOfferDto(Offer offer){
        return OfferResponseDto.builder()
                .id(offer.id())
                .company(offer.company())
                .position(offer.position())
                .salary(offer.salary())
                .offerUrl(offer.offerUrl())
                .build();
    }

   static Offer mapOfferDtoToOffer(OfferRequestDto offerResponseDto){
        return Offer.builder()
                .company(offerResponseDto.company())
                .position(offerResponseDto.position())
                .salary(offerResponseDto.salary())
                .offerUrl(offerResponseDto.offerUrl())
                .build();
    }

    static Offer mapOfferCacheResponseToOffer(OfferCacheResponse offerCacheResponse){
       return Offer.builder()
               .company(offerCacheResponse.company())
               .salary(offerCacheResponse.salary())
               .offerUrl(offerCacheResponse.offerUrl())
               .build();
    }
}
