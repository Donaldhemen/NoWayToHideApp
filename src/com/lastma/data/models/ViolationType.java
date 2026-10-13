package com.lastma.data.models;

public enum ViolationType {
    OVERSPEEDING(25000),
    DUI(20000),
    TRAFFIC_LIGHT_OFFENCE(15000),
    EXPIRED_PAPERS(22000),
    ONE_WAY(18000)
    ;
    ViolationType(int fee) {
    }
}
