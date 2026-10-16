package com.lastma.data.models;

public enum ViolationType {
    OVER_SPEEDING(50000),
    DUI(70000),
    TRAFFIC_LIGHT_OFFENCE(50000),
    EXPIRED_PAPERS(30000),
    ONE_WAY(75000),
    FAKE_PLATE_NUMBER(50000),
    ;
    ViolationType(int fee) {
    }
}
