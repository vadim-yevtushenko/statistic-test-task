package com.example.statistictesttask.api.dto;

import com.example.statistictesttask.api.dto.statistic.SalesByAsinDto;
import com.example.statistictesttask.api.dto.statistic.TrafficByAsinDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AsinStatisticDto {

    private String parentAsin;

    private SalesByAsinDto salesByAsin;

    private TrafficByAsinDto trafficByAsin;

}
