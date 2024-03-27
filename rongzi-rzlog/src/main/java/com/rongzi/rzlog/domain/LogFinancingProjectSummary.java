package com.rongzi.rzlog.domain;

import java.math.BigDecimal;

public class LogFinancingProjectSummary {

    private String month;
    private BigDecimal totalFinancingAmount;
    private BigDecimal totalRepaidAmount;
    private BigDecimal totalRemainingAmount;

    // Getters and Setters
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public BigDecimal getTotalFinancingAmount() {
        return totalFinancingAmount;
    }

    public void setTotalFinancingAmount(BigDecimal totalFinancingAmount) {
        this.totalFinancingAmount = totalFinancingAmount;
    }

    public BigDecimal getTotalRepaidAmount() {
        return totalRepaidAmount;
    }

    public void setTotalRepaidAmount(BigDecimal totalRepaidAmount) {
        this.totalRepaidAmount = totalRepaidAmount;
    }

    public BigDecimal getTotalRemainingAmount() {
        return totalRemainingAmount;
    }

    public void setTotalRemainingAmount(BigDecimal totalRemainingAmount) {
        this.totalRemainingAmount = totalRemainingAmount;
    }
}
