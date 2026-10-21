package com.lastma.dtos.requests;

import com.lastma.data.models.Officer;

public class FindOfficerRequest {
    private String officerId;

    public String getOfficerId() {
        return officerId;
    }

    public void setOfficerId(String officerId) {
        this.officerId = officerId;
    }
}
