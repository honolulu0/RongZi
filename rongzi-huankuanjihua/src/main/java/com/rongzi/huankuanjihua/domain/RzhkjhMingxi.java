package com.rongzi.huankuanjihua.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.rongzi.common.annotation.Excel;
import com.rongzi.common.core.domain.BaseEntity;

/**
 * 还款计划明细对象 rzhkjh_mingxi
 *
 * @author rongzi
 * @date 2024-05-28
 */
public class RzhkjhMingxi extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 管理编号 */
    @Excel(name = "管理编号")
    private String managerId;

    /** 借款人 */
    @Excel(name = "借款人")
    private String borrowingUnit;

    /** 债权人 */
    @Excel(name = "债权人")
    private String financialInstitution;

    /** 贷款用途 */
    @Excel(name = "贷款用途")
    private String daikuanyongtu;

    /** 期数 */
    @Excel(name = "期数")
    private String qishu;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date riqi;

    /** 还款金额 */
    @Excel(name = "还款金额")
    private String huankuanjine;

    /** 偿还本金 */
    @Excel(name = "偿还本金")
    private String changhuanben;

    /** 支付利息 */
    @Excel(name = "支付利息")
    private String zhifulixi;

    /** 手续费 */
    @Excel(name = "手续费")
    private String shouxufei;

    /** 本金剩余 */
    @Excel(name = "本金剩余")
    private String benjinshengyu;

    /** 利率 */
//    @Excel(name = "利率")
    private String lilv;

    /** 备注 */
    @Excel(name = "备注")
    private String comment;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setManagerId(String managerId)
    {
        this.managerId = managerId;
    }

    public String getManagerId()
    {
        return managerId;
    }
    public void setBorrowingUnit(String borrowingUnit)
    {
        this.borrowingUnit = borrowingUnit;
    }

    public String getBorrowingUnit()
    {
        return borrowingUnit;
    }
    public void setFinancialInstitution(String financialInstitution)
    {
        this.financialInstitution = financialInstitution;
    }

    public String getFinancialInstitution()
    {
        return financialInstitution;
    }
    public void setDaikuanyongtu(String daikuanyongtu)
    {
        this.daikuanyongtu = daikuanyongtu;
    }

    public String getDaikuanyongtu()
    {
        return daikuanyongtu;
    }
    public void setQishu(String qishu)
    {
        this.qishu = qishu;
    }

    public String getQishu()
    {
        return qishu;
    }
    public void setRiqi(Date riqi)
    {
        this.riqi = riqi;
    }

    public Date getRiqi()
    {
        return riqi;
    }
    public void setHuankuanjine(String huankuanjine)
    {
        this.huankuanjine = huankuanjine;
    }

    public String getHuankuanjine()
    {
        return huankuanjine;
    }
    public void setChanghuanben(String changhuanben)
    {
        this.changhuanben = changhuanben;
    }

    public String getChanghuanben()
    {
        return changhuanben;
    }
    public void setZhifulixi(String zhifulixi)
    {
        this.zhifulixi = zhifulixi;
    }

    public String getZhifulixi()
    {
        return zhifulixi;
    }
    public void setShouxufei(String shouxufei)
    {
        this.shouxufei = shouxufei;
    }

    public String getShouxufei()
    {
        return shouxufei;
    }
    public void setBenjinshengyu(String benjinshengyu)
    {
        this.benjinshengyu = benjinshengyu;
    }

    public String getBenjinshengyu()
    {
        return benjinshengyu;
    }
    public void setLilv(String lilv)
    {
        this.lilv = lilv;
    }

    public String getLilv()
    {
        return lilv;
    }
    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public String getComment()
    {
        return comment;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("managerId", getManagerId())
                .append("borrowingUnit", getBorrowingUnit())
                .append("financialInstitution", getFinancialInstitution())
                .append("daikuanyongtu", getDaikuanyongtu())
                .append("qishu", getQishu())
                .append("riqi", getRiqi())
                .append("huankuanjine", getHuankuanjine())
                .append("changhuanben", getChanghuanben())
                .append("zhifulixi", getZhifulixi())
                .append("shouxufei", getShouxufei())
                .append("benjinshengyu", getBenjinshengyu())
                .append("lilv", getLilv())
                .append("comment", getComment())
                .append("createTime", getCreateTime())
                .append("createBy", getCreateBy())
                .append("updateTime", getUpdateTime())
                .append("updateBy", getUpdateBy())
                .toString();
    }
}
