package com.rongzi.credit.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.rongzi.common.annotation.Excel;
import com.rongzi.common.core.domain.BaseEntity;
import com.rongzi.appendix.domain.rzsrc2;
/**
 * 信用证对象 rz_credit_letter
 * 
 * @author rongzi
 * @date 2024-03-01
 */
public class rzcreditletter extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 信用证管理编号 */
    @Excel(name = "信用证管理编号")
    private String managementId;

    /** 数据唯一编号 */
    @Excel(name = "数据唯一编号")
    private String scrUuid;

    /** 审核id */
    @Excel(name = "审核id")
    private Long auditId;

    /** 信用证号码 */
    @Excel(name = "信用证号码")
    private String creditNumber;

    /** 开证金额 */
    @Excel(name = "开证金额")
    private Long issuingAmount;

    /** 开证日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开证日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date issuingDate;

    /** 有效日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "有效日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date effectiveDate;

    /** 开证申请人 */
    @Excel(name = "开证申请人")
    private String applicant;

    /** 收益人 */
    @Excel(name = "收益人")
    private String beneficiary;

    /** 金融机构 */
    @Excel(name = "金融机构")
    private String financialInstitution;

    /** 备注 */
    @Excel(name = "备注")
    private String comment;

    /** uuid */
    @Excel(name = "uuid")
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
    public void setAuditId(Long auditId) 
    {
        this.auditId = auditId;
    }

    public Long getAuditId() 
    {
        return auditId;
    }
    public void setCreditNumber(String creditNumber) 
    {
        this.creditNumber = creditNumber;
    }

    public String getCreditNumber() 
    {
        return creditNumber;
    }
    public void setIssuingAmount(Long issuingAmount) 
    {
        this.issuingAmount = issuingAmount;
    }

    public Long getIssuingAmount() 
    {
        return issuingAmount;
    }
    public void setIssuingDate(Date issuingDate) 
    {
        this.issuingDate = issuingDate;
    }

    public Date getIssuingDate() 
    {
        return issuingDate;
    }
    public void setEffectiveDate(Date effectiveDate) 
    {
        this.effectiveDate = effectiveDate;
    }

    public Date getEffectiveDate() 
    {
        return effectiveDate;
    }
    public void setApplicant(String applicant) 
    {
        this.applicant = applicant;
    }

    public String getApplicant() 
    {
        return applicant;
    }
    public void setBeneficiary(String beneficiary) 
    {
        this.beneficiary = beneficiary;
    }

    public String getBeneficiary() 
    {
        return beneficiary;
    }
    public void setFinancialInstitution(String financialInstitution) 
    {
        this.financialInstitution = financialInstitution;
    }

    public String getFinancialInstitution() 
    {
        return financialInstitution;
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
            .append("auditId", getAuditId())
            .append("creditNumber", getCreditNumber())
            .append("issuingAmount", getIssuingAmount())
            .append("issuingDate", getIssuingDate())
            .append("effectiveDate", getEffectiveDate())
            .append("remark", getRemark())
            .append("applicant", getApplicant())
            .append("beneficiary", getBeneficiary())
            .append("financialInstitution", getFinancialInstitution())
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
