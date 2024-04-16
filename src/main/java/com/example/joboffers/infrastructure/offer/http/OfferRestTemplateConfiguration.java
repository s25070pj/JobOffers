package com.example.joboffers.infrastructure.offer.http;


import com.example.joboffers.domain.offer.OfferFetchable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class OfferRestTemplateConfiguration {

    @Bean
    OfferRestTemplateErrorHandler restTemplateResponseErrorHandler(){
        return new OfferRestTemplateErrorHandler();
    }
    @Bean
    RestTemplate restTemplate(OfferRestTemplateErrorHandler offerRestTemplateErrorHandler,
                              @Value("${job-offers.offer.http.client.config.connection-timeout}") long connectionTimeout,
                              @Value("${job-offers.offer.http.client.config.read-timeout}") long readTimeout){
        return new RestTemplateBuilder()
                .errorHandler(offerRestTemplateErrorHandler)
                .setConnectTimeout(Duration.ofMillis(connectionTimeout))
                .setReadTimeout(Duration.ofMillis(readTimeout))
                .build();
    }

    @Bean
    OfferFetchable remoteOfferClient(RestTemplate restTemplate,
                                               @Value("${job-offers.offer.http.client.config.uri}") String uri,
                                               @Value("${job-offers.offer.http.client.config.port}") int port) {
        return new OfferRestTemplate(restTemplate, uri, port);
    }

}
