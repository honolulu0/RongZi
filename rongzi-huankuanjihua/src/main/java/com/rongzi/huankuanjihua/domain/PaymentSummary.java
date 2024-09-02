package com.rongzi.huankuanjihua.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

public class PaymentSummary {
    private String month;
    private BigDecimal totalInterest;
    private BigDecimal totalPrincipal;

    private BigDecimal totalShouxufei;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public BigDecimal getTotalInterest() {
        return totalInterest;
    }

    public void setTotalInterest(BigDecimal totalInterest) {
        this.totalInterest = totalInterest;
    }

    public BigDecimal getTotalPrincipal() {
        return totalPrincipal;
    }

    public void setTotalPrincipal(BigDecimal totalPrincipal) {
        this.totalPrincipal = totalPrincipal;
    }

    public BigDecimal getTotalShouxufei() {
        return totalShouxufei;
    }

    public void setTotalShouxufei(BigDecimal totalShouxufei) {
        this.totalShouxufei = totalShouxufei;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("month", month)
                .append("totalInterest", totalInterest)
                .append("totalPrincipal", totalPrincipal)
                .append("totalShouxufei", totalShouxufei)
                .toString();
    }
}
