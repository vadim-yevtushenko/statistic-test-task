package com.example.statistictesttask.api.dto;

import com.example.statistictesttask.api.dto.statistic.SalesByDateDto;
import com.example.statistictesttask.api.dto.statistic.TrafficByDateDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DateStatisticDto {

    private String date;

    private SalesByDateDto salesByDate;

    private TrafficByDateDto trafficByDate;

}
