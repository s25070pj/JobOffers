package com.example.joboffers.domain.offer;

public class DuplicateOfferException extends RuntimeException{
    public DuplicateOfferException(String message) {
        super(message);
    }
}
