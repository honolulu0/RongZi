package com.rongzi.rzlog.domain;

import java.math.BigDecimal;

public class LogGuaranteeSummary {

    private String month;
    private BigDecimal totalGuaranteeAmount;
    private BigDecimal totalGuaranteeBalance;
    private BigDecimal internalGuaranteeAmount;
    private BigDecimal internalGuaranteeBalance;
    private BigDecimal externalGuaranteeAmount;
    private BigDecimal externalGuaranteeBalance;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

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

    public BigDecimal getInternalGuaranteeAmount() {
        return internalGuaranteeAmount;
    }

    public void setInternalGuaranteeAmount(BigDecimal internalGuaranteeAmount) {
        this.internalGuaranteeAmount = internalGuaranteeAmount;
    }

    public BigDecimal getInternalGuaranteeBalance() {
        return internalGuaranteeBalance;
    }

    public void setInternalGuaranteeBalance(BigDecimal internalGuaranteeBalance) {
        this.internalGuaranteeBalance = internalGuaranteeBalance;
    }

    public BigDecimal getExternalGuaranteeAmount() {
        return externalGuaranteeAmount;
    }

    public void setExternalGuaranteeAmount(BigDecimal externalGuaranteeAmount) {
        this.externalGuaranteeAmount = externalGuaranteeAmount;
    }

    public BigDecimal getExternalGuaranteeBalance() {
        return externalGuaranteeBalance;
    }

    public void setExternalGuaranteeBalance(BigDecimal externalGuaranteeBalance) {
        this.externalGuaranteeBalance = externalGuaranteeBalance;
    }
}
