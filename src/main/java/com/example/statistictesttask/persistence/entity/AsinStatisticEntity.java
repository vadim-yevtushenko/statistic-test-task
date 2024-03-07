package com.example.statistictesttask.persistence.entity;

import com.example.statistictesttask.persistence.entity.statistic.SalesByAsinEntity;
import com.example.statistictesttask.persistence.entity.statistic.TrafficByAsinEntity;
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
@Document(collection = "asin_statistic")
public class AsinStatisticEntity {

    @Id
    private String parentAsin;

    private SalesByAsinEntity salesByAsin;

    private TrafficByAsinEntity trafficByAsin;

}
