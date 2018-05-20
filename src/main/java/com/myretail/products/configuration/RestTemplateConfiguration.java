package com.myretail.products.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Mike
 *         Created on 5/19/2018
 */
@Configuration
public class RestTemplateConfiguration {
    /**
     * Build a RestTemplate
     * @param builder
     * @return a RestTemplate suitable for interacting with a REST API
     */
    @Bean
    RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
