package com.rongzi.rzrepayment.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.rongzi.common.annotation.Excel;
import com.rongzi.common.core.domain.BaseEntity;

/**
 * 还款计划对象 rz_repayment
 * 
 * @author rongzi
 * @date 2024-03-01
 */
public class rzrepayment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 还款计划管理编号 */
    @Excel(name = "还款计划管理编号")
    private String managementId;

    /** 数据唯一编号 */
    @Excel(name = "数据唯一编号")
    private String scrUuid;

    /** 借款单位 */
    @Excel(name = "借款单位")
    private String borrowingUnit;

    /** 金融机构 */
    @Excel(name = "金融机构")
    private String financialInstitution;

    /** 出资机构 */
    @Excel(name = "出资机构")
    private String fundingInstitution;

    /** 借款用途：流贷贷款、并购贷、反向保理、商业承兑、银行承兑 */
    @Excel(name = "借款用途：流贷贷款、并购贷、反向保理、商业承兑、银行承兑")
    private String loanUse;

    /** 增信措施：固定融资、固定资产 */
    @Excel(name = "增信措施：固定融资、固定资产")
    private String creditEnhancementMeasures;

    /** 借款金额 */
    @Excel(name = "借款金额")
    private Long loanAmount;

    /** 手续费 */
    @Excel(name = "手续费")
    private String commission;

    /** 保证金 */
    @Excel(name = "保证金")
    private String margin;

    /** 利率 */
    @Excel(name = "利率")
    private String rate;

    /** 借款日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "借款日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date loanDate;

    /** 到期日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "到期日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dueDate;

    /** 借款期限 */
    @Excel(name = "借款期限")
    private String loanTerm;

    /** 本金偿还方式：先息后本 */
    @Excel(name = "本金偿还方式：先息后本")
    private String principalRepaymentMethod;

    /** 利息偿还方式：先息后本 */
    @Excel(name = "利息偿还方式：先息后本")
    private String interestRepaymentMethod;

    /** 还款账户 */
    @Excel(name = "还款账户")
    private String repaymentAccount;

    /** uuid */
    @Excel(name = "uuid")
    private String uuid;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setManagementId(String managementId) 
    {
        this.managementId = managementId;
    }

    public String getManagementId() 
    {
        return managementId;
    }
    public void setScrUuid(String scrUuid) 
    {
        this.scrUuid = scrUuid;
    }

    public String getScrUuid() 
    {
        return scrUuid;
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
    public void setFundingInstitution(String fundingInstitution) 
    {
        this.fundingInstitution = fundingInstitution;
    }

    public String getFundingInstitution() 
    {
        return fundingInstitution;
    }
    public void setLoanUse(String loanUse) 
    {
        this.loanUse = loanUse;
    }

    public String getLoanUse() 
    {
        return loanUse;
    }
    public void setCreditEnhancementMeasures(String creditEnhancementMeasures) 
    {
        this.creditEnhancementMeasures = creditEnhancementMeasures;
    }

    public String getCreditEnhancementMeasures() 
    {
        return creditEnhancementMeasures;
    }
    public void setLoanAmount(Long loanAmount) 
    {
        this.loanAmount = loanAmount;
    }

    public Long getLoanAmount() 
    {
        return loanAmount;
    }
    public void setCommission(String commission) 
    {
        this.commission = commission;
    }

    public String getCommission() 
    {
        return commission;
    }
    public void setMargin(String margin) 
    {
        this.margin = margin;
    }

    public String getMargin() 
    {
        return margin;
    }
    public void setRate(String rate) 
    {
        this.rate = rate;
    }

    public String getRate() 
    {
        return rate;
    }
    public void setLoanDate(Date loanDate) 
    {
        this.loanDate = loanDate;
    }

    public Date getLoanDate() 
    {
        return loanDate;
    }
    public void setDueDate(Date dueDate) 
    {
        this.dueDate = dueDate;
    }

    public Date getDueDate() 
    {
        return dueDate;
    }
    public void setLoanTerm(String loanTerm) 
    {
        this.loanTerm = loanTerm;
    }

    public String getLoanTerm() 
    {
        return loanTerm;
    }
    public void setPrincipalRepaymentMethod(String principalRepaymentMethod) 
    {
        this.principalRepaymentMethod = principalRepaymentMethod;
    }

    public String getPrincipalRepaymentMethod() 
    {
        return principalRepaymentMethod;
    }
    public void setinterestRepaymentMethod(String interestRepaymentMethod)
    {
        this.interestRepaymentMethod = interestRepaymentMethod;
    }

    public String getinterestRepaymentMethod()
    {
        return interestRepaymentMethod;
    }
    public void setRepaymentAccount(String repaymentAccount) 
    {
        this.repaymentAccount = repaymentAccount;
    }

    public String getRepaymentAccount() 
    {
        return repaymentAccount;
    }
    public void setUuid(String uuid) 
    {
        this.uuid = uuid;
    }

    public String getUuid() 
    {
        return uuid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("managementId", getManagementId())
            .append("scrUuid", getScrUuid())
            .append("borrowingUnit", getBorrowingUnit())
            .append("financialInstitution", getFinancialInstitution())
            .append("fundingInstitution", getFundingInstitution())
            .append("loanUse", getLoanUse())
            .append("creditEnhancementMeasures", getCreditEnhancementMeasures())
            .append("loanAmount", getLoanAmount())
            .append("commission", getCommission())
            .append("margin", getMargin())
            .append("rate", getRate())
            .append("loanDate", getLoanDate())
            .append("dueDate", getDueDate())
            .append("remark", getRemark())
            .append("loanTerm", getLoanTerm())
            .append("principalRepaymentMethod", getPrincipalRepaymentMethod())
            .append("interestRepaymentMethod", getinterestRepaymentMethod())
            .append("repaymentAccount", getRepaymentAccount())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("uuid", getUuid())
            .toString();
    }
}
