package com.lastma.data.models;

import java.time.LocalDate;
public class Ticket {
    private String id;
    private String offenceId;
    private String vehicleId;
    private String officerId;
    private String ticketNumber;
    private String location;
    private String description;
    private String status;
    private int violationFee;
    private LocalDate issuedAt;
    private LocalDate incidentDateTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getOffenceId() {
        return offenceId;
    }

    public void setOffenceId(String offenceId) {
        this.offenceId = offenceId;
    }
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
    public String getOfficerId() {
        return officerId;
    }

    public void setOfficerId(String issuedByOfficerId) {
        this.officerId = issuedByOfficerId;
    }
    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public int getViolationFee() {
        return violationFee;
    }

    public void setViolationFee(int violationFee) {
        this.violationFee = violationFee;
    }
    public LocalDate getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(LocalDate issuedAt) {
        this.issuedAt = issuedAt;
    }
    public LocalDate getIncidentDateTime() {
        return incidentDateTime;
    }

    public void setIncidentDateTime(LocalDate incidentDateTime) {
        this.incidentDateTime = incidentDateTime;
    }
}
