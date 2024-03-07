package com.example.statistictesttask.api.dto.statistic;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class OrderedProductSalesDto {

    private double amount;

    private String currencyCode;

}
