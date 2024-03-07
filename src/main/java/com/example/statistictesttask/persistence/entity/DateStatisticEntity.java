package com.example.statistictesttask.persistence.entity;

import com.example.statistictesttask.persistence.entity.statistic.SalesByDateEntity;
import com.example.statistictesttask.persistence.entity.statistic.TrafficByDateEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Document(collection = "date_statistic")
public class DateStatisticEntity {

    @Id
    private String date;

    private SalesByDateEntity salesByDate;

    private TrafficByDateEntity trafficByDate;

}
