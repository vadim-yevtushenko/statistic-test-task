package com.example.statistictesttask.persistence.entity.statistic;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ClaimsAmountEntity {

    private double amount;

    private String currencyCode;

}
