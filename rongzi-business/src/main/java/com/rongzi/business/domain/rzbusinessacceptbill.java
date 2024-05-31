package com.rongzi.business.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.rongzi.common.annotation.Excel;
import com.rongzi.common.core.domain.BaseEntity;
import com.rongzi.appendix.domain.rzsrc2;
/**
 * 商业承兑汇票对象 rz_business_accept_bill
 *
 * @author rongzi
 * @date 2024-05-30
 */
public class rzbusinessacceptbill extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 商业承兑管理编号 */
    @Excel(name = "商业承兑管理编号")
    private String managementId;

    /** 数据唯一编号 */
    @Excel(name = "数据唯一编号")
    private String scrUuid;

    /** 审核id */
    @Excel(name = "审核id")
    private Long auditId;

    /** 付款人 */
    @Excel(name = "付款人")
    private String payer;

    /** 收款人 */
    @Excel(name = "收款人")
    private String payee;

    /** 出票金额 */
    @Excel(name = "出票金额")
    private Long invoiceAmount;

    /** 出票日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出票日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date draftDate;

    /** 到期日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "到期日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dueDate;

    /** 合同号码 */
    @Excel(name = "合同号码")
    private String contractNumber;

    /** 金融机构 */
    @Excel(name = "金融机构")
    private String financialInstitution;

    /** 备注 */
    @Excel(name = "备注")
    private String comment;

    /** uuid */
    @Excel(name = "uuid")
    private String uuid;

    /** 是否已贴现 */
    @Excel(name = "是否已贴现")
    private String discountedOrNot;

    /** 贴现金融机构 */
    @Excel(name = "贴现金融机构")
    private String discountedFinancialInstitutions;

    /** 贴现手续费 */
    @Excel(name = "贴现手续费")
    private String discountedHandlingFee;

    /** 贴现费用承担情况 */
    @Excel(name = "贴现费用承担情况")
    private String assumptionOfDiscountFees;

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
    public void setPayer(String payer)
    {
        this.payer = payer;
    }

    public String getPayer()
    {
        return payer;
    }
    public void setPayee(String payee)
    {
        this.payee = payee;
    }

    public String getPayee()
    {
        return payee;
    }
    public void setInvoiceAmount(Long invoiceAmount)
    {
        this.invoiceAmount = invoiceAmount;
    }

    public Long getInvoiceAmount()
    {
        return invoiceAmount;
    }
    public void setDraftDate(Date draftDate)
    {
        this.draftDate = draftDate;
    }

    public Date getDraftDate()
    {
        return draftDate;
    }
    public void setDueDate(Date dueDate)
    {
        this.dueDate = dueDate;
    }

    public Date getDueDate()
    {
        return dueDate;
    }
    public void setContractNumber(String contractNumber)
    {
        this.contractNumber = contractNumber;
    }

    public String getContractNumber()
    {
        return contractNumber;
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
    public void setDiscountedOrNot(String discountedOrNot)
    {
        this.discountedOrNot = discountedOrNot;
    }

    public String getDiscountedOrNot()
    {
        return discountedOrNot;
    }
    public void setDiscountedFinancialInstitutions(String discountedFinancialInstitutions)
    {
        this.discountedFinancialInstitutions = discountedFinancialInstitutions;
    }

    public String getDiscountedFinancialInstitutions()
    {
        return discountedFinancialInstitutions;
    }
    public void setDiscountedHandlingFee(String discountedHandlingFee)
    {
        this.discountedHandlingFee = discountedHandlingFee;
    }

    public String getDiscountedHandlingFee()
    {
        return discountedHandlingFee;
    }
    public void setAssumptionOfDiscountFees(String assumptionOfDiscountFees)
    {
        this.assumptionOfDiscountFees = assumptionOfDiscountFees;
    }

    public String getAssumptionOfDiscountFees()
    {
        return assumptionOfDiscountFees;
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
                .append("payer", getPayer())
                .append("payee", getPayee())
                .append("invoiceAmount", getInvoiceAmount())
                .append("draftDate", getDraftDate())
                .append("dueDate", getDueDate())
                .append("remark", getRemark())
                .append("contractNumber", getContractNumber())
                .append("financialInstitution", getFinancialInstitution())
                .append("comment", getComment())
                .append("createTime", getCreateTime())
                .append("createBy", getCreateBy())
                .append("updateTime", getUpdateTime())
                .append("updateBy", getUpdateBy())
                .append("uuid", getUuid())
                .append("discountedOrNot", getDiscountedOrNot())
                .append("discountedFinancialInstitutions", getDiscountedFinancialInstitutions())
                .append("discountedHandlingFee", getDiscountedHandlingFee())
                .append("assumptionOfDiscountFees", getAssumptionOfDiscountFees())
                .append("rzsrc2List", getrzsrc2List())
                .toString();
    }
}
