package com.journi.challenge.controllers;

import com.journi.challenge.models.CurrencyCode;
import com.journi.challenge.models.Purchase;
import com.journi.challenge.models.PurchaseRequest;
import com.journi.challenge.models.PurchaseStats;
import com.journi.challenge.repositories.PurchasesRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class PurchasesController {

    private static final Logger logger = LogManager.getLogger(PurchasesController.class);

    @Inject
    private PurchasesRepository purchasesRepository;

    @GetMapping("/purchases/statistics")
    public PurchaseStats getStats() {
        logger.info("Getting all stats");
        return purchasesRepository.getLast30DaysStats();
    }

    @GetMapping("/purchases")
    public List<Purchase> getPurchases() {
        logger.info("Getting all purchases");
        return purchasesRepository.list();
    }

    @PostMapping("/purchases")
    public Purchase save(@RequestBody PurchaseRequest purchaseRequest) {
        logger.info("Creating new purchase {}", purchaseRequest.toString());
        Purchase newPurchase = new Purchase(
                purchaseRequest.getInvoiceNumber(),
                LocalDateTime.parse(purchaseRequest.getDateTime(), DateTimeFormatter.ISO_DATE_TIME),
                purchaseRequest.getProductIds(),
                purchaseRequest.getCustomerName(),
                purchaseRequest.getAmount(),
                CurrencyCode.valueOf(purchaseRequest.getCurrencyCode())
        );
        purchasesRepository.save(newPurchase);
        return newPurchase;
    }
}
