package com.rongzi.creditmanagement.domain;

import java.math.BigDecimal;

public class BillSummary {
    private BigDecimal totalChangkouedu;
    private BigDecimal totalInProgressChangkouedu;

    // Getters and Setters
    public BigDecimal getTotalChangkouedu() {
        return totalChangkouedu;
    }

    public void setTotalChangkouedu(BigDecimal totalChangkouedu) {
        this.totalChangkouedu = totalChangkouedu;
    }

    public BigDecimal getTotalInProgressChangkouedu() {
        return totalInProgressChangkouedu;
    }

    public void setTotalInProgressChangkouedu(BigDecimal totalInProgressChangkouedu) {
        this.totalInProgressChangkouedu = totalInProgressChangkouedu;
    }
}
