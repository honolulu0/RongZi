package com.rongzi.creditmanagement.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.rongzi.common.annotation.Excel;
import com.rongzi.common.core.domain.BaseEntity;
import com.rongzi.appendix.domain.rzsrc2;
/**
 * 授信管理对象 rz_credit_management
 * 
 * @author rongzi
 * @date 2024-03-05
 */
public class rzcreditmanagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 授信管理管理编号 */
    @Excel(name = "管理编号")
    private String managementId;

    /** 数据唯一编号 */
    private String scrUuid;

    /** 债权人/借款人 */
    @Excel(name = "借款人")
    private String creditor;

    /** 金融机构 */
    @Excel(name = "债权人")
    private String financialInstitution;

    /** 授信类型：授信流资、低风险、项目贷、回租贷 */
    @Excel(name = "授信类型")
    private String creditType;

    /** 授信详情 */
    @Excel(name = "授信详情")
    private String creditDetail;

    /** 授信金额 */
    @Excel(name = "授信金额")
    private Long creditAmount;

    /** 已用授信金额 */
    @Excel(name = "已用授信金额")
    private Long usedCreditAmount;

    /** 剩余授信金额 */
    @Excel(name = "剩余授信金额")
    private Long remainingCreditAmount;

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

    /** 授信状态：授信中、已授信 */
    @Excel(name = "授信状态")
    private String creditState;

    /** 备注 */
    @Excel(name = "备注")
    private String comment;

    /** uuid */
    private String uuid;

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
    public void setCreditor(String creditor) 
    {
        this.creditor = creditor;
    }

    public String getCreditor() 
    {
        return creditor;
    }
    public void setFinancialInstitution(String financialInstitution) 
    {
        this.financialInstitution = financialInstitution;
    }

    public String getFinancialInstitution() 
    {
        return financialInstitution;
    }
    public void setCreditType(String creditType) 
    {
        this.creditType = creditType;
    }

    public String getCreditType() 
    {
        return creditType;
    }
    public void setCreditDetail(String creditDetail) 
    {
        this.creditDetail = creditDetail;
    }

    public String getCreditDetail() 
    {
        return creditDetail;
    }
    public void setCreditAmount(Long creditAmount) 
    {
        this.creditAmount = creditAmount;
    }

    public Long getCreditAmount() 
    {
        return creditAmount;
    }
    public void setUsedCreditAmount(Long usedCreditAmount) 
    {
        this.usedCreditAmount = usedCreditAmount;
    }

    public Long getUsedCreditAmount() 
    {
        return usedCreditAmount;
    }
    public void setRemainingCreditAmount(Long remainingCreditAmount) 
    {
        this.remainingCreditAmount = remainingCreditAmount;
    }

    public Long getRemainingCreditAmount() 
    {
        return remainingCreditAmount;
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
    public void setCreditState(String creditState) 
    {
        this.creditState = creditState;
    }

    public String getCreditState() 
    {
        return creditState;
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
            .append("creditor", getCreditor())
            .append("financialInstitution", getFinancialInstitution())
            .append("creditType", getCreditType())
            .append("creditDetail", getCreditDetail())
            .append("creditAmount", getCreditAmount())
            .append("usedCreditAmount", getUsedCreditAmount())
            .append("remainingCreditAmount", getRemainingCreditAmount())
            .append("startDate", getStartDate())
            .append("deadline", getDeadline())
            .append("creditCycle", getCreditCycle())
            .append("creditState", getCreditState())
            .append("comment", getComment())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("uuid", getUuid())
            .append("rzsrc2List", getrzsrc2List())
            .toString();
    }
}
