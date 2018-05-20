package com.myretail.products.configuration;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author Mike
 *         Created on 5/17/2018
 */
@Configuration
public class MongoConfiguration {
    @Value("${mongo.host}")
    private String host;

    @Value("${mongo.database}")
    private String databaseName;

    /**
     * Get a MongoTemplate
     * @return a MongoTemplate suitable for interacting with the database configured in application.properties
     */
    @Bean
    MongoTemplate getMongoTemplate() {
        return new MongoTemplate(new MongoClient(host), databaseName);
    }
}
