package com.lastma.data.models;

public class Offence {
    private String id;
    private String code;
    private String name;
    private String description;
    private int penaltyPoints;
    private int firstOffenceFine;
    private int subsequentOffenceFine;
    private String additionalPenaltyDescription;
    private boolean active;
    private ViolationType violationType;

    public Offence() {}
    public Offence(ViolationType violationType) {
        this.violationType = violationType;
    }
    public ViolationType getViolationType() {
        return violationType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPenaltyPoints() {
        return penaltyPoints;
    }

    public void setPenaltyPoints(int penaltyPoints) {
        this.penaltyPoints = penaltyPoints;
    }

    public int getFirstOffenceFine() {
        return firstOffenceFine;
    }

    public void setFirstOffenceFine(int firstOffenceFine) {
        this.firstOffenceFine = firstOffenceFine;
    }

    public int getSubsequentOffenceFine() {
        return subsequentOffenceFine;
    }

    public void setSubsequentOffenceFine(int subsequentOffenceFine) {
        this.subsequentOffenceFine = subsequentOffenceFine;
    }

    public String getAdditionalPenaltyDescription() {
        return additionalPenaltyDescription;
    }

    public void setAdditionalPenaltyDescription(String additionalPenaltyDescription) {
        this.additionalPenaltyDescription = additionalPenaltyDescription;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
