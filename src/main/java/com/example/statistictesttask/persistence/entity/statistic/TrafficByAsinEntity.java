package com.example.statistictesttask.persistence.entity.statistic;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class TrafficByAsinEntity {

    private int browserSessions;

    private int browserSessionsB2B;

    private int mobileAppSessions;

    private int mobileAppSessionsB2B;

    private int sessions;

    private int sessionsB2B;

    private double browserSessionPercentage;

    private int browserSessionPercentageB2B;

    private double mobileAppSessionPercentage;

    private int mobileAppSessionPercentageB2B;

    private double sessionPercentage;

    private int sessionPercentageB2B;

    private int browserPageViews;

    private int browserPageViewsB2B;

    private int mobileAppPageViews;

    private int mobileAppPageViewsB2B;

    private int pageViews;

    private int pageViewsB2B;

    private double browserPageViewsPercentage;

    private int browserPageViewsPercentageB2B;

    private double mobileAppPageViewsPercentage;

    private int mobileAppPageViewsPercentageB2B;

    private double pageViewsPercentage;

    private int pageViewsPercentageB2B;

    private int buyBoxPercentage;

    private int buyBoxPercentageB2B;

    private double unitSessionPercentage;

    private int unitSessionPercentageB2B;

}
