package com.rongzi.creditmanagement.domain;

import java.math.BigDecimal;

public class RzFinancingProjectSummary {
    private BigDecimal totalFinancingAmount;
    private BigDecimal totalRemainingAmount;

    public BigDecimal getTotalFinancingAmount() {
        return totalFinancingAmount;
    }

    public void setTotalFinancingAmount(BigDecimal totalFinancingAmount) {
        this.totalFinancingAmount = totalFinancingAmount;
    }

    public BigDecimal getTotalRemainingAmount() {
        return totalRemainingAmount;
    }

    public void setTotalRemainingAmount(BigDecimal totalRemainingAmount) {
        this.totalRemainingAmount = totalRemainingAmount;
    }
// Getters and Setters
}
