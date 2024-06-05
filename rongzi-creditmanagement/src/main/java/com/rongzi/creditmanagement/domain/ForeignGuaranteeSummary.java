package com.rongzi.creditmanagement.domain;

import java.math.BigDecimal;

public class ForeignGuaranteeSummary {
    private BigDecimal totalGuaranteeAmount;
    private BigDecimal totalGuaranteeBalance;

    public BigDecimal getTotalGuaranteeAmount() {

            if(totalGuaranteeAmount == null) {
                return BigDecimal.ZERO;
            } else {
                return totalGuaranteeAmount;
            }

    }

    public void setTotalGuaranteeAmount(BigDecimal totalGuaranteeAmount) {
        this.totalGuaranteeAmount = totalGuaranteeAmount;
    }

    public BigDecimal getTotalGuaranteeBalance() {
        if (totalGuaranteeBalance == null) {
            return BigDecimal.ZERO;
        } else {
            return totalGuaranteeBalance;
        }
    }

    public void setTotalGuaranteeBalance(BigDecimal totalGuaranteeBalance) {
        this.totalGuaranteeBalance = totalGuaranteeBalance;
    }
}
