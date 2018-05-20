package com.myretail.products.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * @author Mike
 *         Created on 5/19/2018
 */
@Service
public class ProductNameService {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Value("${pns.url}")
    private String rootUrl;

    @Value("${pns.query_string}")
    private String query;

    /**
     * Retrieve product name from the external resource
     * @param id
     * @return
     * @throws IOException
     */
    public String getProductName(int id) throws IOException {
        // Get the product data
        String url = rootUrl + id + query;
        String jsonResponse = restTemplate.getForObject(url, String.class);

        // Parse the JSON response
        JsonNode rootNode = new ObjectMapper().readTree(jsonResponse);
        String name = rootNode.get("product").get("item").get("product_description").get("title").textValue();

        logger.debug("Got the following product name: " + name);
        return name;
    }
}
