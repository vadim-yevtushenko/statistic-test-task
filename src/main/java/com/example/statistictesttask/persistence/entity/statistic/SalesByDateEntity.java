package com.example.statistictesttask.persistence.entity.statistic;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class SalesByDateEntity {

    private OrderedProductSalesEntity orderedProductSales;

    private OrderedProductSalesB2BEntity orderedProductSalesB2B;

    private int unitsOrdered;

    private int unitsOrderedB2B;

    private int totalOrderItems;

    private int totalOrderItemsB2B;

    private AverageSalesPerOrderItemEntity averageSalesPerOrderItem;

    private AverageSalesPerOrderItemB2BEntity averageSalesPerOrderItemB2B;

    private double averageUnitsPerOrderItem;

    private double averageUnitsPerOrderItemB2B;

    private AverageSellingPriceEntity averageSellingPrice;

    private AverageSellingPriceB2BEntity averageSellingPriceB2B;

    private int unitsRefunded;

    private double refundRate;

    private int claimsGranted;

    private ClaimsAmountEntity claimsAmount;

    private ShippedProductSalesEntity shippedProductSales;

    private int unitsShipped;

    private int ordersShipped;

}
