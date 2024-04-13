package com.rongzi.huankuanjihua.domain;

import com.rongzi.common.core.page.TableDataInfo;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

public class TotalRzhkjhMingxi {
    private BigDecimal total_huankuanjine;
    private BigDecimal total_changhuanben;
    private BigDecimal total_zhifulixi;

    private TableDataInfo tableDataInfo;

    public BigDecimal getTotal_huankuanjine() {
        return total_huankuanjine;
    }

    public void setTotal_huankuanjine(BigDecimal total_huankuanjine) {
        this.total_huankuanjine = total_huankuanjine;
    }

    public BigDecimal getTotal_changhuanben() {
        return total_changhuanben;
    }

    public void setTotal_changhuanben(BigDecimal total_changhuanben) {
        this.total_changhuanben = total_changhuanben;
    }

    public BigDecimal getTotal_zhifulixi() {
        return total_zhifulixi;
    }

    public void setTotal_zhifulixi(BigDecimal total_zhifulixi) {
        this.total_zhifulixi = total_zhifulixi;
    }

    public TableDataInfo getTableDataInfo() {
        return tableDataInfo;
    }

    public void setTableDataInfo(TableDataInfo tableDataInfo) {
        this.tableDataInfo = tableDataInfo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("total_huankuanjine", total_huankuanjine)
                .append("total_changhuanben", total_changhuanben)
                .append("total_zhifulixi", total_zhifulixi)
                .append("tableDataInfo", tableDataInfo)
                .toString();
    }
}
