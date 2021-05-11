package com.kyocoolcool.springsecurity.productservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * @author 陳金昌 Chris Chen
 * @version 1.0 2021/2/2 6:06 PM
 */
@EnableOAuth2Client
@Configuration
public class OauthClientConfig {
        @Value("${oauth.resource:http://localhost:9092}")
        private String baseUrl;
        @Value("${oauth.authorize:http://localhost:9092/oauth/authorize}")
        private String authorizeUrl;
        @Value("${oauth.token:http://localhost:9092/oauth/token}")
        private String tokenUrl;

    @Bean
    @ConfigurationProperties("my.oauth2")
    protected OAuth2ProtectedResourceDetails resource() {
        return new ResourceOwnerPasswordResourceDetails();
    }

//        @Bean
//        protected OAuth2ProtectedResourceDetails resource() {
//            ResourceOwnerPasswordResourceDetails resource;
//            resource = new ResourceOwnerPasswordResourceDetails();
//
//            List scopes = new ArrayList<String>(2);
//            scopes.add("write");
//            scopes.add("read");
//            resource.setAccessTokenUri(tokenUrl);
//            resource.setClientId("couponclientapp");
//            resource.setClientSecret("9999");
//            resource.setGrantType("password");
//            resource.setScope(scopes);
//            resource.setUsername("doug@bailey.com");
//            resource.setPassword("doug");
//            return resource;
//        }

        @Bean
        public OAuth2RestOperations oAuth2RestTemplate() {
            AccessTokenRequest atr = new DefaultAccessTokenRequest();
            return new OAuth2RestTemplate(resource(), new DefaultOAuth2ClientContext(atr));
        }
    }
