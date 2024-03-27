package com.rongzi.creditmanagement.domain;

import java.math.BigDecimal;

public class GovernmentSpecialBondsSummary {
    private BigDecimal totalApprovedAmount;
    private BigDecimal totalRemainingAmount;

    public BigDecimal getTotalApprovedAmount() {
        return totalApprovedAmount;
    }

    public void setTotalApprovedAmount(BigDecimal totalApprovedAmount) {
        this.totalApprovedAmount = totalApprovedAmount;
    }

    public BigDecimal getTotalRemainingAmount() {
        return totalRemainingAmount;
    }

    public void setTotalRemainingAmount(BigDecimal totalRemainingAmount) {
        this.totalRemainingAmount = totalRemainingAmount;
    }
// Getters and Setters
}
