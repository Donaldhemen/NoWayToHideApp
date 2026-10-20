package com.lastma.data.models;

import java.time.LocalDate;

public class Challenge {
    private String id;
    private String ticketId;
    private String reason;
    private String status;
    private String decisionNotes;
    private String reviewedByOfficerId;
    private LocalDate submittedAt;
    private LocalDate revisedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDecisionNotes() {
        return decisionNotes;
    }

    public void setDecisionNotes(String decisionNotes) {
        this.decisionNotes = decisionNotes;
    }

    public String getReviewedByOfficerId() {
        return reviewedByOfficerId;
    }

    public void setReviewedByOfficerId(String reviewedByOfficerId) {
        this.reviewedByOfficerId = reviewedByOfficerId;
    }

    public LocalDate getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDate submittedAt) {
        this.submittedAt = submittedAt;
    }

    public LocalDate getRevisedAt() {
        return revisedAt;
    }

    public void setRevisedAt(LocalDate revisedAt) {
        this.revisedAt = revisedAt;
    }
}
