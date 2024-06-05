package com.rongzi.rzlog.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.rongzi.common.annotation.Excel;
import com.rongzi.common.core.domain.BaseEntity;

/**
 * 历史融资查询对象 rzlog_financing_project
 * 
 * @author rongzi
 * @date 2024-03-24
 */
public class RzlogFinancingProject extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 贷后项目管理编号 */
    @Excel(name = "贷后项目管理编号")
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

    /** 融资金额 */
    @Excel(name = "融资金额")
    private Long financingAmount;

    /** 融资类型：流贷金额、并购贷、反向保理、商业承兑、银行承兑 */
    @Excel(name = "融资类型：流贷金额、并购贷、反向保理、商业承兑、银行承兑")
    private String financingType;

    /** 合同编号 */
    @Excel(name = "合同编号")
    private String contractId;

    /** 合同签订日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "合同签订日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date contractSigningDate;

    /** 借款日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "借款日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date loanDate;

    /** 到期日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "到期日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dueDate;

    /** 利率 */
//    @Excel(name = "利率")
    private String rate;

    /** 借款期限 */
    @Excel(name = "借款期限")
    private String loanTerm;

    /** 增信措施：固定融资、固定资产 */
    @Excel(name = "增信措施：固定融资、固定资产")
    private String creditEnhancementMeasures;

    /** 已还金额 */
    @Excel(name = "已还金额")
    private Long repaidAmount;

    /** 待还金额 */
    @Excel(name = "待还金额")
    private Long remainingAmount;

    /** 贷款状态：未结清、已结清 */
    @Excel(name = "贷款状态：未结清、已结清")
    private String loanState;

    /** 备注 */
    @Excel(name = "备注")
    private String comment;

    /** uuid */
    
    private String uuid;

    /** 记录创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记录创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date logCreateTime;

    /** 记录创建的年月 */
    @Excel(name = "记录创建的年月")
    private String logCreateDate;

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
    public void setFinancingAmount(Long financingAmount) 
    {
        this.financingAmount = financingAmount;
    }

    public Long getFinancingAmount() 
    {
        return financingAmount;
    }
    public void setFinancingType(String financingType) 
    {
        this.financingType = financingType;
    }

    public String getFinancingType() 
    {
        return financingType;
    }
    public void setContractId(String contractId) 
    {
        this.contractId = contractId;
    }

    public String getContractId() 
    {
        return contractId;
    }
    public void setContractSigningDate(Date contractSigningDate) 
    {
        this.contractSigningDate = contractSigningDate;
    }

    public Date getContractSigningDate() 
    {
        return contractSigningDate;
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
    public void setRate(String rate) 
    {
        this.rate = rate;
    }

    public String getRate() 
    {
        return rate;
    }
    public void setLoanTerm(String loanTerm) 
    {
        this.loanTerm = loanTerm;
    }

    public String getLoanTerm() 
    {
        return loanTerm;
    }
    public void setCreditEnhancementMeasures(String creditEnhancementMeasures) 
    {
        this.creditEnhancementMeasures = creditEnhancementMeasures;
    }

    public String getCreditEnhancementMeasures() 
    {
        return creditEnhancementMeasures;
    }
    public void setRepaidAmount(Long repaidAmount) 
    {
        this.repaidAmount = repaidAmount;
    }

    public Long getRepaidAmount() 
    {
        return repaidAmount;
    }
    public void setRemainingAmount(Long remainingAmount) 
    {
        this.remainingAmount = remainingAmount;
    }

    public Long getRemainingAmount() 
    {
        return remainingAmount;
    }
    public void setLoanState(String loanState) 
    {
        this.loanState = loanState;
    }

    public String getLoanState() 
    {
        return loanState;
    }
    public void setComment(String comment) 
    {
        this.comment = comment;
    }

    public String getComment() 
    {
        return comment;
    }
    public void setUuid(String uuid) 
    {
        this.uuid = uuid;
    }

    public String getUuid() 
    {
        return uuid;
    }
    public void setLogCreateTime(Date logCreateTime) 
    {
        this.logCreateTime = logCreateTime;
    }

    public Date getLogCreateTime() 
    {
        return logCreateTime;
    }
    public void setLogCreateDate(String logCreateDate) 
    {
        this.logCreateDate = logCreateDate;
    }

    public String getLogCreateDate() 
    {
        return logCreateDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("managementId", getManagementId())
            .append("scrUuid", getScrUuid())
            .append("borrowingUnit", getBorrowingUnit())
            .append("financialInstitution", getFinancialInstitution())
            .append("financingAmount", getFinancingAmount())
            .append("financingType", getFinancingType())
            .append("contractId", getContractId())
            .append("contractSigningDate", getContractSigningDate())
            .append("loanDate", getLoanDate())
            .append("dueDate", getDueDate())
            .append("rate", getRate())
            .append("loanTerm", getLoanTerm())
            .append("creditEnhancementMeasures", getCreditEnhancementMeasures())
            .append("repaidAmount", getRepaidAmount())
            .append("remainingAmount", getRemainingAmount())
            .append("loanState", getLoanState())
            .append("comment", getComment())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("uuid", getUuid())
            .append("logCreateTime", getLogCreateTime())
            .append("logCreateDate", getLogCreateDate())
            .toString();
    }
}
