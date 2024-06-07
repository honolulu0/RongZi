package com.rongzi.rzafterloan.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.rongzi.common.annotation.Excel;
import com.rongzi.common.core.domain.BaseEntity;
import com.rongzi.appendix.domain.rzsrc2;
/**
 * 贷后管理对象 rz_after_loan
 * 
 * @author rongzi
 * @date 2024-03-20
 */
public class rzafterloan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 贷后项目管理编号 */
    @Excel(name = "贷后项目管理编号")
    private String managementId;

    /** 数据唯一编号 */
    //@Excel(name = "数据唯一编号")
    private String scrUuid;

    /** 金融机构 */
    @Excel(name = "金融机构")
    private String financialInstitution;

    /** 借款金额 */
    @Excel(name = "借款金额")
    private Long loanAmount;

    /** 借款单位 */
    @Excel(name = "借款单位")
    private String borrowingUnit;

    /** 借款期限 */
    @Excel(name = "借款期限")
    private String loanTerm;

    /** 贷后状态跟踪：未完结、已完结 */
    @Excel(name = "贷后状态跟踪：未完结、已完结")
    private String afterLoanState;

    /** 量化内容 */
    @Excel(name = "量化内容")
    private String quantitativeContent;

    /** 量化目标 */
    @Excel(name = "量化目标")
    private String quantitativeGoals;

    /** 当前实现 */
    @Excel(name = "当前实现")
    private String currentImplementation;

    /** 剩余数量 */
    @Excel(name = "剩余数量")
    private String remainingQuantity;

    /** 进度说明 */
    @Excel(name = "进度说明")
    private String progressDescription;

    /** 备注 */
    @Excel(name = "备注")
    private String comment;

    /** uuid */
    
    private String uuid;

    /** 开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 截止日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "截止日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deadline;

    /** 授信周期 */
    @Excel(name = "授信周期")
    private String creditCycle;

    /** 附件表信息 */
    private List<rzsrc2> rzsrc2List;

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
    public void setFinancialInstitution(String financialInstitution) 
    {
        this.financialInstitution = financialInstitution;
    }

    public String getFinancialInstitution() 
    {
        return financialInstitution;
    }
    public void setLoanAmount(Long loanAmount) 
    {
        this.loanAmount = loanAmount;
    }

    public Long getLoanAmount() 
    {
        return loanAmount;
    }
    public void setBorrowingUnit(String borrowingUnit) 
    {
        this.borrowingUnit = borrowingUnit;
    }

    public String getBorrowingUnit() 
    {
        return borrowingUnit;
    }
    public void setLoanTerm(String loanTerm) 
    {
        this.loanTerm = loanTerm;
    }

    public String getLoanTerm() 
    {
        return loanTerm;
    }
    public void setAfterLoanState(String afterLoanState) 
    {
        this.afterLoanState = afterLoanState;
    }

    public String getAfterLoanState() 
    {
        return afterLoanState;
    }
    public void setQuantitativeContent(String quantitativeContent) 
    {
        this.quantitativeContent = quantitativeContent;
    }

    public String getQuantitativeContent() 
    {
        return quantitativeContent;
    }
    public void setQuantitativeGoals(String quantitativeGoals) 
    {
        this.quantitativeGoals = quantitativeGoals;
    }

    public String getQuantitativeGoals() 
    {
        return quantitativeGoals;
    }
    public void setCurrentImplementation(String currentImplementation) 
    {
        this.currentImplementation = currentImplementation;
    }

    public String getCurrentImplementation() 
    {
        return currentImplementation;
    }
    public void setRemainingQuantity(String remainingQuantity) 
    {
        this.remainingQuantity = remainingQuantity;
    }

    public String getRemainingQuantity() 
    {
        return remainingQuantity;
    }
    public void setProgressDescription(String progressDescription) 
    {
        this.progressDescription = progressDescription;
    }

    public String getProgressDescription() 
    {
        return progressDescription;
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
    public void setStartDate(Date startDate) 
    {
        this.startDate = startDate;
    }

    public Date getStartDate() 
    {
        return startDate;
    }
    public void setDeadline(Date deadline) 
    {
        this.deadline = deadline;
    }

    public Date getDeadline() 
    {
        return deadline;
    }
    public void setCreditCycle(String creditCycle) 
    {
        this.creditCycle = creditCycle;
    }

    public String getCreditCycle() 
    {
        return creditCycle;
    }

    public List<rzsrc2> getrzsrc2List()
    {
        return rzsrc2List;
    }

    public void setrzsrc2List(List<rzsrc2> rzsrc2List)
    {
        this.rzsrc2List = rzsrc2List;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("managementId", getManagementId())
            .append("scrUuid", getScrUuid())
            .append("financialInstitution", getFinancialInstitution())
            .append("loanAmount", getLoanAmount())
            .append("borrowingUnit", getBorrowingUnit())
            .append("loanTerm", getLoanTerm())
            .append("afterLoanState", getAfterLoanState())
            .append("quantitativeContent", getQuantitativeContent())
            .append("quantitativeGoals", getQuantitativeGoals())
            .append("currentImplementation", getCurrentImplementation())
            .append("remainingQuantity", getRemainingQuantity())
            .append("progressDescription", getProgressDescription())
            .append("comment", getComment())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("uuid", getUuid())
            .append("startDate", getStartDate())
            .append("deadline", getDeadline())
            .append("creditCycle", getCreditCycle())
            .append("rzsrc2List", getrzsrc2List())
            .toString();
    }
}
