package com.myretail.products.repository;

import com.myretail.products.model.Price;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.io.IOException;

/**
 * @author Mike
 *         Created on 5/17/2018
 */
@Repository
public class PricesRepository {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Get price info for given product id
     * @param id
     * @return
     * @throws IOException
     */
    public Price getPriceById(int id) throws IOException {
        return mongoTemplate.findOne(
                Query.query(Criteria.where("_id").is(id)),
                Price.class
        );
    }

    /**
     * Update price for given product id
     * @param id
     * @param newPrice
     * @throws IOException
     */
    public void updateProductPriceById(int id, Price newPrice) throws IOException {
        Price price = mongoTemplate.findOne(Query.query(Criteria.where("_id").is(id)), Price.class);
        price.setValue(newPrice.getValue());
        price.setCurrency_code(newPrice.getCurrency_code());
        mongoTemplate.save(price);
    }
}
