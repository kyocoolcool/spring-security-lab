package com.kyocoolcool.springsecurity.productservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
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

    private static final String REGISTRATION_URL = "http://localhost:8080/register";
    private static final String RESOURCES_URL = "http://localhost:9091/couponapi/coupons/SUPERSALE3";
    private static final String AUTHENTICATION_URL = "http://localhost:8080/authenticate";
    private static final String HELLO_URL = "http://localhost:8080/helloadmin";

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getResponse() throws JsonProcessingException {

        String response = null;
        // create user registration object
//        RegistrationUser registrationUser = getRegistrationUser();
        // convert the user registration object to JSON
//        String registrationBody = getBody(registrationUser);
        // create headers specifying that it is JSON request
        HttpHeaders headers = getHeaders();
        headers.set("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiY291cG9uc2VydmljZSJdLCJ1c2VyX25hbWUiOiJkb3VnQGJhaWxleS5jb20iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNjExOTYyODE4LCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIl0sImp0aSI6IjVhMjgwMjBiLTAzNDQtNDVlZi1hMmYxLTI0YjMyZDkzYWIxOSIsImNsaWVudF9pZCI6ImNvdXBvbmNsaWVudGFwcCJ9.VU2zNlwQT1x3RVsEoj5eFxy2vUXQExtDPbRBhvACzZP4RlT9m2T6LYx_QmElne_DMutV2FFrJqZUyND41XYV0pZDHfA7QaaduB1j3g27nw49h4XslAEi3efKXALSk3FaIyOohDpm6ZLMZ_x6QdB5lyfFKnB0oTjUCf2DsqbGtqSsnW07PcwvalpoBlI5N9WZhQLaXo4P3uxm86IPZnMrlSHj33EXByWsviGd5_gy6Cx4ffQKiV04KojIuAUGUMKp_Hc4GvUc_3lOR3W907Upk1nBbZfyFD35jdQuGoHDC97s22-TF0cey7bmF0JtjeWovlQfVQb1_i57joof6NOTRQ");
        HttpEntity<String> registrationEntity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> exchange = restTemplate.exchange(RESOURCES_URL, HttpMethod.GET, registrationEntity, String.class);
        response = exchange.getBody();
        System.out.println(response);

//        try {
        // Register User
//            ResponseEntity<String> registrationResponse = restTemplate.exchange(REGISTRATION_URL, HttpMethod.POST,
//                    registrationEntity, String.class);
        // if the registration is successful
//            System.out.println(registrationResponse.getStatusCode().equals(HttpStatus.OK));

//            if (registrationResponse.getStatusCode().equals(HttpStatus.OK)) {

        // create user authentication object
//                User authenticationUser = getAuthenticationUser();
        // convert the user authentication object to JSON
//                String authenticationBody = getBody(authenticationUser);
        // create headers specifying that it is JSON request
//                HttpHeaders authenticationHeaders = getHeaders();
//                HttpEntity<String> authenticationEntity = new HttpEntity<String>(authenticationBody,
//                        authenticationHeaders);

        // Authenticate User and get JWT
//                ResponseEntity<ResponseToken> authenticationResponse = restTemplate.exchange(AUTHENTICATION_URL,
//                        HttpMethod.POST, authenticationEntity, ResponseToken.class);

        // if the authentication is successful
//                System.out.println(authenticationResponse.getStatusCode().equals(HttpStatus.OK));
        // if the authentication is successful
//                if (authenticationResponse.getStatusCode().equals(HttpStatus.OK)) {
//                    String token = "Bearer " + authenticationResponse.getBody().getToken();
//                    HttpHeaders headers = getHeaders();
//                    headers.set("Authorization", token);
//                    HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
        // Use Token to get Response
//                    ResponseEntity<String> helloResponse = restTemplate.exchange(HELLO_URL, HttpMethod.GET, jwtEntity,
//                            String.class);
//                    if (helloResponse.getStatusCode().equals(HttpStatus.OK)) {
//                        response = helloResponse.getBody();
//                    }
//                }

//            }


//        } catch (Exception ex) {
//            System.out.println("exception");
//
//        }
        return response;

    }

//    private RegistrationUser getRegistrationUser() {
//        RegistrationUser user = new RegistrationUser();
//        user.setUsername("javainuse");
//        user.setPassword("javainuse");
//        user.setRole("ROLE_ADMIN");
//        return user;
//    }

//    private User getAuthenticationUser() {
//        User user = new User();
//        user.setUsername("javainuse");
//        user.setPassword("javainuse");
//        return user;
//    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }

//    private String getBody(final User user) throws JsonProcessingException {
//        return new ObjectMapper().writeValueAsString(user);
//    }
}
