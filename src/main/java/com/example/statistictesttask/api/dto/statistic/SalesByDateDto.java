package com.example.statistictesttask.api.dto.statistic;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class SalesByDateDto {

    private OrderedProductSalesDto orderedProductSales;

    private OrderedProductSalesB2BDto orderedProductSalesB2B;

    private int unitsOrdered;

    private int unitsOrderedB2B;

    private int totalOrderItems;

    private int totalOrderItemsB2B;

    private AverageSalesPerOrderItemDto averageSalesPerOrderItem;

    private AverageSalesPerOrderItemB2BDto averageSalesPerOrderItemB2B;

    private double averageUnitsPerOrderItem;

    private double averageUnitsPerOrderItemB2B;

    private AverageSellingPriceDto averageSellingPrice;

    private AverageSellingPriceB2BDto averageSellingPriceB2B;

    private int unitsRefunded;

    private double refundRate;

    private int claimsGranted;

    private ClaimsAmountDto claimsAmount;

    private ShippedProductSalesDto shippedProductSales;

    private int unitsShipped;

    private int ordersShipped;

}
