package com.myretail.products.controller;

import com.myretail.products.model.Product;
import com.myretail.products.repository.PricesRepository;
import com.myretail.products.service.ProductService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author Mike
 *         Created on 5/17/2018
 */
@RestController
public class ProductsController {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProductService productService;

    @Autowired PricesRepository pricesRepository;

    /**
     * Get product information for specified id
     * @param id Product id number
     * @return Product information
     * @throws IOException
     */
    @GetMapping(value="/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProductInfoById(@PathVariable("id") String id) throws IOException {
        return new ResponseEntity<Product>(productService.getProductDataById(Integer.parseInt(id)), HttpStatus.OK);
    }

    /**
     * Update product price information for specified id
     * @param id Product id number
     * @param product product information; all fields except current_price are ignored
     * @return HTTP stauts
     * @throws IOException
     */
    @PutMapping(value="/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity setProductPrice(@PathVariable("id") String id, @RequestBody Product product) throws IOException {
        pricesRepository.updateProductPriceById(Integer.parseInt(id), product.getCurrent_price());
        return ResponseEntity.ok().build();
    }
}
