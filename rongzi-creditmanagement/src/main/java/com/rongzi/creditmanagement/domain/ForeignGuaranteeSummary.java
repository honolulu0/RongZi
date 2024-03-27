package com.rongzi.creditmanagement.domain;

import java.math.BigDecimal;

public class ForeignGuaranteeSummary {
    private BigDecimal totalGuaranteeAmount;
    private BigDecimal totalGuaranteeBalance;

    public BigDecimal getTotalGuaranteeAmount() {
        return totalGuaranteeAmount;
    }

    public void setTotalGuaranteeAmount(BigDecimal totalGuaranteeAmount) {
        this.totalGuaranteeAmount = totalGuaranteeAmount;
    }

    public BigDecimal getTotalGuaranteeBalance() {
        return totalGuaranteeBalance;
    }

    public void setTotalGuaranteeBalance(BigDecimal totalGuaranteeBalance) {
        this.totalGuaranteeBalance = totalGuaranteeBalance;
    }
}
