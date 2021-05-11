package com.kyocoolcool.springsecurity.productservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/1/29 7:17 PM
 */
@RestController
@RequestMapping("/productapi")
public class HelloController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private OAuth2RestOperations oAuth2RestTemplate;
    //    private static final String REGISTRATION_URL = "http://localhost:8080/register";
    private static final String RESOURCES_URL = "http://localhost:9091/couponapi/coupons/SUPERSALE3";
//    private static final String AUTHENTICATION_URL = "http://localhost:8080/authenticate";
//    private static final String HELLO_URL = "http://localhost:8080/helloadmin";

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getResponse() throws JsonProcessingException {
        OAuth2AccessToken accessToken = oAuth2RestTemplate.getAccessToken();
        System.out.println(accessToken);
        String response = null;
        HttpHeaders headers = getHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<String> registrationEntity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> exchange = restTemplate.exchange(RESOURCES_URL, HttpMethod.GET, registrationEntity, String.class);
        response = exchange.getBody();
        System.out.println(response);
        return response;

    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }

}
