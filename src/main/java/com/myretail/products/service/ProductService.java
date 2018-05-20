package com.myretail.products.service;

import com.myretail.products.model.Product;
import com.myretail.products.repository.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Mike
 *         Created on 5/20/2018
 */
@Service
public class ProductService {
    @Autowired
    private PricesRepository pricesRepository;

    @Autowired
    private ProductNameService productNameService;

    public Product getProductDataById(int id) throws IOException {
        Product product = new Product();
        product.setId(id);
        product.setCurrent_price(pricesRepository.getPriceById(id));
        product.setName(productNameService.getProductName(product.getId()));

        return product;
    }
}
