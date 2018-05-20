package com.myretail.products.model;

/**
 * @author Mike
 *         Created on 5/17/2018
 */
public class Product {
    private int id;
    private String name;
    private Price current_price;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Price getCurrent_price() { return current_price; }
    public void setCurrent_price(Price current_price) { this.current_price = current_price; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
}
