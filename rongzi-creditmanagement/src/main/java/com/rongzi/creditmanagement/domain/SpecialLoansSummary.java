package com.rongzi.creditmanagement.domain;

import java.math.BigDecimal;

public class SpecialLoansSummary {
    private BigDecimal totalLoanAmount;
    private BigDecimal totalBalance;

    public BigDecimal getTotalLoanAmount() {
        if (totalLoanAmount == null) {
            return BigDecimal.ZERO;
        } else {
            return totalLoanAmount;
        }
    }

    public void setTotalLoanAmount(BigDecimal totalLoanAmount) {
        this.totalLoanAmount = totalLoanAmount;
    }

    public BigDecimal getTotalBalance() {
        if (totalBalance == null) {
            return BigDecimal.ZERO;
        } else {
            return totalBalance;
        }
    }

    public void setTotalBalance(BigDecimal totalBalance) {
        this.totalBalance = totalBalance;
    }
// Getters and Setters
}