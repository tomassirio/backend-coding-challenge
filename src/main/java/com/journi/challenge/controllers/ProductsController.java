package com.journi.challenge.controllers;

import com.journi.challenge.models.Product;
import com.journi.challenge.repositories.ProductsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
public class ProductsController {

    private static final Logger logger = LogManager.getLogger(ProductsController.class);

    @Inject
    private ProductsRepository productsRepository;

    @GetMapping("/products")
    public List<Product> list(@RequestParam(name = "countryCode", defaultValue = "EUR") String countryCode) {
        logger.info("Listing products with country name {}", countryCode);
        return productsRepository.list(countryCode);
    }
}
