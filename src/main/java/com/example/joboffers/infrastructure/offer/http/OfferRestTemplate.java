package com.example.joboffers.infrastructure.offer.http;


import com.example.joboffers.domain.offer.OfferFetchable;
import com.example.joboffers.domain.offer.dto.JobOfferResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Log4j2
@AllArgsConstructor
public class OfferRestTemplate implements OfferFetchable {

    private final RestTemplate restTemplate;
    private final String uri;
    private final int port;

    @Override
    public List<JobOfferResponse> fetchOffers() {
        log.info("Started fetching offers using http client");
        String urlForService = getUrlForService("/offers");
        final String url = UriComponentsBuilder.fromHttpUrl(urlForService)
                .toUriString();
        HttpHeaders headers = new HttpHeaders();
        final HttpEntity<HttpHeaders> requestEntity = new HttpEntity<>(headers);


        try {
            ResponseEntity<List<JobOfferResponse>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    requestEntity,
                    new ParameterizedTypeReference<List<JobOfferResponse>>() {
                    });
            final List<JobOfferResponse> offers = response.getBody();
            if (offers == null) {
                log.info("Response Body was null returning empty list");
                return Collections.emptyList();
            }
            log.info("Success Response Body Returned: " + offers);
            return offers;
        } catch (
                ResourceAccessException e) {
            log.error("Error while fetching offers using http client: " + e.getMessage());
            return Collections.emptyList();
        }


    }

    private String getUrlForService(String service) {
        return uri + ":" + port + service;
    }
}
