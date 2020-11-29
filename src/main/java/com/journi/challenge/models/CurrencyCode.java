package com.journi.challenge.models;

public enum CurrencyCode {

    EUR("EUR"),
    USD("USD"),
    ARS("ARS"),
    BRL("BRL");

    private String currency;

    CurrencyCode(String currency){
        this.currency = currency;
    }

    public String currency(){
        return currency;
    }
}
