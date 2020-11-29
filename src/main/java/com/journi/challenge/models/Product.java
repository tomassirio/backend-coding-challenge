package com.journi.challenge.models;

import io.swagger.annotations.ApiModelProperty;

/**
 * Represents a Product the company can sell.
 * Id is of course unique.
 * price is always in Euros.
 */
public class Product {

    private final String id;
    @ApiModelProperty(example = "A Brief description of the Product")
    private final String description;
    @ApiModelProperty(example = "9.5")
    private final Double price;
    @ApiModelProperty(example = "EUR")
    private final CurrencyCode currencyCode;

    public Product(String id, String description, Double price, CurrencyCode currencyCode) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.currencyCode = currencyCode;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

}
