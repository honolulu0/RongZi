package com.rongzi.creditmanagement.domain;

import com.rongzi.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 信用管理统计实体类
 */
public class rzcreditmanagementsummary extends BaseEntity {
    private String creditType;
    private BigDecimal totalAmount;
    private BigDecimal totalRemainingAmount;

    // Getters and setters for each field
    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    // 注意：在getter方法中直接进行格式化处理
    // 注意：在getter方法中直接进行格式化处理，并处理null值
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public BigDecimal getTotalRemainingAmount() {
        return totalRemainingAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setTotalRemainingAmount(BigDecimal totalRemainingAmount) {
        this.totalRemainingAmount = totalRemainingAmount;
    }

    // Helper method to format BigDecimal
    private BigDecimal formatBigDecimal(BigDecimal value) {
        return value != null ? value.setScale(2, RoundingMode.HALF_UP) : BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
    }
}
