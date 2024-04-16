package com.example.joboffers.infrastructure.offer.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

public class OfferRestTemplateErrorHandler extends DefaultResponseErrorHandler {

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        final HttpStatus statusCode = HttpStatus.valueOf(response.getStatusCode().value());
        final HttpStatus.Series series = statusCode.series();
        if (series == SERVER_ERROR) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while using http client");
        } else if (series == CLIENT_ERROR) {
            if (statusCode == HttpStatus.NOT_FOUND) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            } else if (statusCode == HttpStatus.UNAUTHORIZED) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
            }
        }
    }

}
