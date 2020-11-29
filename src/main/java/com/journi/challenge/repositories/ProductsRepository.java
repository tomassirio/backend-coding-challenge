package com.journi.challenge.repositories;

import com.journi.challenge.CurrencyConverter;
import com.journi.challenge.models.CurrencyCode;
import com.journi.challenge.models.Product;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Named
@Singleton
public class ProductsRepository {

    private CurrencyConverter currencyConverter = new CurrencyConverter();

    private List<Product> allProducts = new ArrayList<>();
    {
        allProducts.add(new Product("photobook-square-soft-cover", "Photobook Square with Soft Cover", 25.0, CurrencyCode.EUR));
        allProducts.add(new Product("photobook-square-hard-cover", "Photobook Square with Hard Cover", 30.0, CurrencyCode.USD));
        allProducts.add(new Product("photobook-landscape-soft-cover", "Photobook Landscape with Soft Cover", 35.0, CurrencyCode.ARS));
        allProducts.add(new Product("photobook-landscape-hard-cover", "Photobook Landscape with Hard Cover", 45.0, CurrencyCode.BRL));
    }

    public List<Product> list(String countryCode) {
        return allProducts.stream().map(
                product ->
                        new Product(
                                product.getId(),
                                product.getDescription(),
                                currencyConverter.convertEurToCurrency(currencyConverter.getCurrencyForCountryCode(countryCode), product.getPrice()),
                                product.getCurrencyCode()))
                .collect(Collectors.toList());
    }

}
