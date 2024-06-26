package com.rongzi.rzlog.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.rongzi.common.annotation.Excel;
import com.rongzi.common.core.domain.BaseEntity;

/**
 * 历史担保对象 rzlog_guarantee
 * 
 * @author rongzi
 * @date 2024-03-24
 */
public class RzlogGuarantee extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 管理编号 */
    @Excel(name = "管理编号")
    private String managementId;

    /** 担保合同编号 */
    @Excel(name = "担保合同编号")
    private String contractId;

    /** 数据唯一编号 */
    //@Excel(name = "数据唯一编号")
    private String scrUuid;

    /** 借款人 */
    @Excel(name = "借款人")
    private String creditor;

    /** 担保人 */
    @Excel(name = "担保人")
    private String guarantor;

    /** 金融机构 */
    @Excel(name = "金融机构")
    private String financialInstitution;

    /** 业务类型：股东借款、固定资产贷款、流贷贷款、银行借款、授信流资 */
    @Excel(name = "业务类型")
    private String businessType;

    /** 担保金额 */
    @Excel(name = "担保金额")
    private Long guaranteeAmount;

    /** 担保余额 */
    @Excel(name = "担保余额")
    private Long guaranteeBalance;

    /** 开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 截止日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "截止日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deadline;

    /** 保证方式：连带责任保证、某某责任保证、有追责权、意外责任、兼容责任 */
    @Excel(name = "保证方式")
    private String guaranteeMethod;

    /** 是否上征信：是、否 */
    @Excel(name = "是否上征信")
    private String isCreditInvestigation;

    /** 备注 */
    @Excel(name = "备注")
    private String comment;

    /** uuid */
    
    private String uuid;

    /** 类型 */
    @Excel(name = "类型")
    private String type;

    /** 记录创建的年月 */
    @Excel(name = "记录创建的年月")
    private String logCreateDate;

    /** 记录创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记录创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date logCreateTime;

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
    public void setContractId(String contractId) 
    {
        this.contractId = contractId;
    }

    public String getContractId() 
    {
        return contractId;
    }
    public void setScrUuid(String scrUuid) 
    {
        this.scrUuid = scrUuid;
    }

    public String getScrUuid() 
    {
        return scrUuid;
    }
    public void setCreditor(String creditor) 
    {
        this.creditor = creditor;
    }

    public String getCreditor() 
    {
        return creditor;
    }
    public void setGuarantor(String guarantor) 
    {
        this.guarantor = guarantor;
    }

    public String getGuarantor() 
    {
        return guarantor;
    }
    public void setFinancialInstitution(String financialInstitution) 
    {
        this.financialInstitution = financialInstitution;
    }

    public String getFinancialInstitution() 
    {
        return financialInstitution;
    }
    public void setBusinessType(String businessType) 
    {
        this.businessType = businessType;
    }

    public String getBusinessType() 
    {
        return businessType;
    }
    public void setGuaranteeAmount(Long guaranteeAmount) 
    {
        this.guaranteeAmount = guaranteeAmount;
    }

    public Long getGuaranteeAmount() 
    {
        return guaranteeAmount;
    }
    public void setGuaranteeBalance(Long guaranteeBalance) 
    {
        this.guaranteeBalance = guaranteeBalance;
    }

    public Long getGuaranteeBalance() 
    {
        return guaranteeBalance;
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
    public void setGuaranteeMethod(String guaranteeMethod) 
    {
        this.guaranteeMethod = guaranteeMethod;
    }

    public String getGuaranteeMethod() 
    {
        return guaranteeMethod;
    }
    public void setIsCreditInvestigation(String isCreditInvestigation) 
    {
        this.isCreditInvestigation = isCreditInvestigation;
    }

    public String getIsCreditInvestigation() 
    {
        return isCreditInvestigation;
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
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setLogCreateDate(String logCreateDate) 
    {
        this.logCreateDate = logCreateDate;
    }

    public String getLogCreateDate() 
    {
        return logCreateDate;
    }
    public void setLogCreateTime(Date logCreateTime) 
    {
        this.logCreateTime = logCreateTime;
    }

    public Date getLogCreateTime() 
    {
        return logCreateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("managementId", getManagementId())
            .append("contractId", getContractId())
            .append("scrUuid", getScrUuid())
            .append("creditor", getCreditor())
            .append("guarantor", getGuarantor())
            .append("financialInstitution", getFinancialInstitution())
            .append("businessType", getBusinessType())
            .append("guaranteeAmount", getGuaranteeAmount())
            .append("guaranteeBalance", getGuaranteeBalance())
            .append("startDate", getStartDate())
            .append("deadline", getDeadline())
            .append("guaranteeMethod", getGuaranteeMethod())
            .append("isCreditInvestigation", getIsCreditInvestigation())
            .append("comment", getComment())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("uuid", getUuid())
            .append("type", getType())
            .append("logCreateDate", getLogCreateDate())
            .append("logCreateTime", getLogCreateTime())
            .toString();
    }
}
