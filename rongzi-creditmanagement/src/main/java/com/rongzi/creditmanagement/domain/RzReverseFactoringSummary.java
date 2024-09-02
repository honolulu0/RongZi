package com.rongzi.creditmanagement.domain;

import java.math.BigDecimal;

public class RzReverseFactoringSummary {
    private BigDecimal totalLoanAmount;
    private BigDecimal totalInProgressLoanAmount;

    public BigDecimal getTotalLoanAmount() {
        return totalLoanAmount;
    }

    public void setTotalLoanAmount(BigDecimal totalLoanAmount) {
        this.totalLoanAmount = totalLoanAmount;
    }

    public BigDecimal getTotalInProgressLoanAmount() {
        return totalInProgressLoanAmount;
    }

    public void setTotalInProgressLoanAmount(BigDecimal totalInProgressLoanAmount) {
        this.totalInProgressLoanAmount = totalInProgressLoanAmount;
    }
// Getters and Setters
}
