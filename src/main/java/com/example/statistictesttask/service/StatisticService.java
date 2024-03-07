package com.example.statistictesttask.service;

import com.example.statistictesttask.persistence.entity.AsinStatisticEntity;
import com.example.statistictesttask.persistence.entity.DateStatisticEntity;

import java.util.List;

public interface StatisticService {

    List<DateStatisticEntity> getAllDateStatistics(String startDate, String finishDate);

    List<AsinStatisticEntity> getAsinStatistics(List<String> asins);

    void saveAllDate(List<DateStatisticEntity> dateStatisticEntityList);

    void saveAllAsin(List<AsinStatisticEntity> asinStatisticEntityList);

}
