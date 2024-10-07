package com.hakkinenT.cinemamongo.models.entities.sessions.embedded;

public class Price {
    private Double fullValue;
    private Double halfValue;
    
    public Price() {
    }

    public Price(Double fullValue, Double halfValue) {
        this.fullValue = fullValue;
        this.halfValue = halfValue;
    }

    public Double getFullValue() {
        return fullValue;
    }

    public void setFullValue(Double fullValue) {
        this.fullValue = fullValue;
    }

    public Double getHalfValue() {
        return halfValue;
    }

    public void setHalfValue(Double halfValue) {
        this.halfValue = halfValue;
    }  
}
