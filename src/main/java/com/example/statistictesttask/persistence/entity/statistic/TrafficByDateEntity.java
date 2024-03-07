package com.example.statistictesttask.persistence.entity.statistic;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class TrafficByDateEntity {

    private int browserPageViews;

    private int browserPageViewsB2B;

    private int mobileAppPageViews;

    private int mobileAppPageViewsB2B;

    private int pageViews;

    private int pageViewsB2B;

    private int browserSessions;

    private int browserSessionsB2B;

    private int mobileAppSessions;

    private int mobileAppSessionsB2B;

    private int sessions;

    private int sessionsB2B;

    private double buyBoxPercentage;

    private double buyBoxPercentageB2B;

    private double orderItemSessionPercentage;

    private double orderItemSessionPercentageB2B;

    private double unitSessionPercentage;

    private int unitSessionPercentageB2B;

    private int averageOfferCount;

    private int averageParentItems;

    private int feedbackReceived;

    private int negativeFeedbackReceived;

    private int receivedNegativeFeedbackRate;

}
