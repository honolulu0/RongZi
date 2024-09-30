package com.rongzi.huankuanjihua.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

public class FinancialSummary {
    private BigDecimal totalPrincipal;
    private BigDecimal totalInterest;
    private BigDecimal totalShouxufei;
    private BigDecimal totalPaidPrincipal;
    private BigDecimal totalUnpaidPrincipal;
    private BigDecimal totalPaidInterest;
    private BigDecimal totalUnpaidInterest;
    private BigDecimal totalPaidShouxufei;
    private BigDecimal totalUnpaidShouxufei;

    public BigDecimal getTotalPrincipal() {
        return totalPrincipal;
    }

    public void setTotalPrincipal(BigDecimal totalPrincipal) {
        this.totalPrincipal = totalPrincipal;
    }

    public BigDecimal getTotalInterest() {
        return totalInterest;
    }

    public void setTotalInterest(BigDecimal totalInterest) {
        this.totalInterest = totalInterest;
    }

    public BigDecimal getTotalPaidPrincipal() {
        return totalPaidPrincipal;
    }

    public void setTotalPaidPrincipal(BigDecimal totalPaidPrincipal) {
        this.totalPaidPrincipal = totalPaidPrincipal;
    }

    public BigDecimal getTotalUnpaidPrincipal() {
        return totalUnpaidPrincipal;
    }

    public void setTotalUnpaidPrincipal(BigDecimal totalUnpaidPrincipal) {
        this.totalUnpaidPrincipal = totalUnpaidPrincipal;
    }

    public BigDecimal getTotalPaidInterest() {
        return totalPaidInterest;
    }

    public void setTotalPaidInterest(BigDecimal totalPaidInterest) {
        this.totalPaidInterest = totalPaidInterest;
    }

    public BigDecimal getTotalUnpaidInterest() {
        return totalUnpaidInterest;
    }

    public void setTotalUnpaidInterest(BigDecimal totalUnpaidInterest) {
        this.totalUnpaidInterest = totalUnpaidInterest;
    }

    public BigDecimal getTotalShouxufei() {
        return totalShouxufei;
    }

    public void setTotalShouxufei(BigDecimal totalShouxufei) {
        this.totalShouxufei = totalShouxufei;
    }

    public BigDecimal getTotalPaidShouxufei() {
        return totalPaidShouxufei;
    }

    public void setTotalPaidShouxufei(BigDecimal totalPaidShouxufei) {
        this.totalPaidShouxufei = totalPaidShouxufei;
    }

    public BigDecimal getTotalUnpaidShouxufei() {
        return totalUnpaidShouxufei;
    }

    public void setTotalUnpaidShouxufei(BigDecimal totalUnpaidShouxufei) {
        this.totalUnpaidShouxufei = totalUnpaidShouxufei;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("totalPrincipal", totalPrincipal)
                .append("totalInterest", totalInterest)
                .append("totalInterest", totalShouxufei)
                .append("totalPaidPrincipal", totalPaidPrincipal)
                .append("totalUnpaidPrincipal", totalUnpaidPrincipal)
                .append("totalPaidInterest", totalPaidInterest)
                .append("totalUnpaidInterest", totalUnpaidInterest)
                .append("totalPaidInterest", totalPaidShouxufei)
                .append("totalUnpaidInterest", totalUnpaidShouxufei)
                .toString();
    }
}
