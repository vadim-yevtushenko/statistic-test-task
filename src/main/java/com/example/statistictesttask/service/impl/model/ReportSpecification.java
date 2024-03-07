package com.example.statistictesttask.service.impl.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReportSpecification {

    private String reportType;

    private ReportOptions reportOptions;

    private LocalDate dataStartTime;

    private LocalDate dataEndTime;

    private List<String> marketplaceIds;

}
