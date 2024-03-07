package com.example.statistictesttask.api.dto.statistic;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class SalesByAsinDto {

    private int unitsOrdered;

    private int unitsOrderedB2B;

    private OrderedProductSalesDto orderedProductSales;

    private OrderedProductSalesB2BDto orderedProductSalesB2B;

    private int totalOrderItems;

    private int totalOrderItemsB2B;
    
}
