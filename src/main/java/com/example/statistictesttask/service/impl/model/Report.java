package com.example.statistictesttask.service.impl.model;

import com.example.statistictesttask.persistence.entity.AsinStatisticEntity;
import com.example.statistictesttask.persistence.entity.DateStatisticEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Report {

    private ReportSpecification reportSpecification;

    private List<DateStatisticEntity> salesAndTrafficByDate;

    private List<AsinStatisticEntity> salesAndTrafficByAsin;

}
