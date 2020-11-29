package com.journi.challenge.models;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents a completed Purchase.
 * invoiceNumber is unique
 * timestamp when the purchase was made. Epoch milliseconds
 * productIds list of product ids included in this purchase
 * customerName name of the customer
 * totalValue total value of this purchase, in EUR
 */
public class Purchase {

    @ApiModelProperty(example = "1")
    private final String invoiceNumber;
    @ApiModelProperty(example = "2020-11-29T16:55:05.920Z")
    private final LocalDateTime timestamp;
    private final List<String> productIds;
    @ApiModelProperty(example = "Tomas Sirio")
    private final String customerName;
    @ApiModelProperty(example = "42")
    private final Double totalValue;
    @ApiModelProperty(example = "EUR")
    private final CurrencyCode currencyCode;

    public Purchase(String invoiceNumber, LocalDateTime timestamp, List<String> productIds, String customerName, Double totalValue, CurrencyCode currencyCode) {
        this.invoiceNumber = invoiceNumber;
        this.timestamp = timestamp;
        this.productIds = productIds;
        this.customerName = customerName;
        this.totalValue = totalValue;
        this.currencyCode = currencyCode;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public List<String> getProductIds() {
        return productIds;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public CurrencyCode getCurrencyCode() { return currencyCode; }
}
