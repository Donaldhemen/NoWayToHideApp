package com.lastma.dtos.responses;

public class FindOfficerResponse {
    private String fullName;
    private String officerNumber;
    private String id;
    private boolean isActive;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getOfficerNumber() {
        return officerNumber;
    }

    public void setOfficerNumber(String officerNumber) {
        this.officerNumber = officerNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
