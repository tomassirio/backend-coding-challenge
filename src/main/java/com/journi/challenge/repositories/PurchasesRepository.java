package com.journi.challenge.repositories;

import com.journi.challenge.CurrencyConverter;
import com.journi.challenge.models.CurrencyCode;
import com.journi.challenge.models.Purchase;
import com.journi.challenge.models.PurchaseStats;

import javax.inject.Named;
import javax.inject.Singleton;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Named
@Singleton
public class PurchasesRepository {

    private CurrencyConverter currencyConverter = new CurrencyConverter();

    private final List<Purchase> allPurchases = new ArrayList<>();
    private List<Purchase> recentPurchases = new ArrayList<>();
    private Double totalAmountPurchases = 0.0;
    private Double minAmountPurchase = 0.0;
    private Double maxAmountPurchase = 0.0;

    public List<Purchase> list() {
        return allPurchases;
    }

    public void save(Purchase purchase) {
        allPurchases.add(purchase);

        LocalDateTime start = LocalDate.now().atStartOfDay().minusDays(30);

        recentPurchases = allPurchases
                .stream()
                .filter(p -> p.getTimestamp().isAfter(start))
                .sorted(Comparator.comparing(Purchase::getTimestamp))
                .map(p ->
                        new Purchase(
                                p.getInvoiceNumber(),
                                p.getTimestamp(),
                                p.getProductIds(),
                                p.getCustomerName(),
                                currencyConverter.convertEurToCurrency(CurrencyCode.EUR.currency(), p.getTotalValue()),
                                CurrencyCode.EUR))
                .collect(Collectors.toList());

        totalAmountPurchases = recentPurchases.stream().mapToDouble(Purchase::getTotalValue).sum();
        minAmountPurchase = recentPurchases.stream().mapToDouble(Purchase::getTotalValue).min().orElse(0.0);
        maxAmountPurchase = recentPurchases.stream().mapToDouble(Purchase::getTotalValue).max().orElse(0.0);
    }

    public PurchaseStats getLast30DaysStats() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE.withZone(ZoneId.of("UTC"));

        long countPurchases = recentPurchases.size();
        return new PurchaseStats(
                formatter.format(recentPurchases.get(0).getTimestamp()),
                formatter.format(recentPurchases.get(recentPurchases.size() - 1).getTimestamp()),
                countPurchases,
                totalAmountPurchases,
                totalAmountPurchases / countPurchases,
                minAmountPurchase,
                maxAmountPurchase
        );
    }
}
