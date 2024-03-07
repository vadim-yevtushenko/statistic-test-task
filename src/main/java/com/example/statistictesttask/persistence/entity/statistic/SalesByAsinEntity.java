package com.example.statistictesttask.persistence.entity.statistic;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class SalesByAsinEntity {

    private int unitsOrdered;

    private int unitsOrderedB2B;

    private OrderedProductSalesEntity orderedProductSales;

    private OrderedProductSalesB2BEntity orderedProductSalesB2B;

    private int totalOrderItems;

    private int totalOrderItemsB2B;
    
}
