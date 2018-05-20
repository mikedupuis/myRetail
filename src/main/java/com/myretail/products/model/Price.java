package com.myretail.products.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Mike
 *         Created on 5/19/2018
 */
@Document(collection = "prices")
public class Price {
    @Id
    @JsonIgnore
    private int id;
    private double value;
    private String currency_code;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }

    public String getCurrency_code() { return currency_code; }
    public void setCurrency_code(String currency_code) { this.currency_code = currency_code; }
}
