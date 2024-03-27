package com.rongzi.bankaccept.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.rongzi.common.annotation.Excel;
import com.rongzi.common.core.domain.BaseEntity;

/**
 * 银行承兑汇票对象 rz_bank_accept_bill
 * 
 * @author rongzi
 * @date 2024-02-08
 */
public class rzbankacceptbill extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 银行承兑管理编号 */
    private String managementId;

    /** 附件 */
    @Excel(name = "附件")
    private String scrUuid;

    /** 审核id */
    @Excel(name = "审核id")
    private Long auditId;

    /** 出票人 */
    @Excel(name = "出票人")
    private String drawer;

    /** 收票人 */
    @Excel(name = "收票人")
    private String payee;

    /** 金融机构 */
    @Excel(name = "金融机构")
    private String financialInstitution;

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

    /** 协议编号 */
    @Excel(name = "协议编号")
    private String acceptAgreementId;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String entryName;

    /** 备注 */
    @Excel(name = "备注")
    private String comment;

    /** $table.subTable.functionName信息 */
    private List<RzScr> rzScrList;

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
    public void setDrawer(String drawer) 
    {
        this.drawer = drawer;
    }

    public String getDrawer() 
    {
        return drawer;
    }
    public void setPayee(String payee) 
    {
        this.payee = payee;
    }

    public String getPayee() 
    {
        return payee;
    }
    public void setFinancialInstitution(String financialInstitution) 
    {
        this.financialInstitution = financialInstitution;
    }

    public String getFinancialInstitution() 
    {
        return financialInstitution;
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
    public void setAcceptAgreementId(String acceptAgreementId) 
    {
        this.acceptAgreementId = acceptAgreementId;
    }

    public String getAcceptAgreementId() 
    {
        return acceptAgreementId;
    }
    public void setEntryName(String entryName) 
    {
        this.entryName = entryName;
    }

    public String getEntryName() 
    {
        return entryName;
    }
    public void setComment(String comment) 
    {
        this.comment = comment;
    }

    public String getComment() 
    {
        return comment;
    }

    public List<RzScr> getRzScrList()
    {
        return rzScrList;
    }

    public void setRzScrList(List<RzScr> rzScrList)
    {
        this.rzScrList = rzScrList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("managementId", getManagementId())
            .append("scrUuid", getScrUuid())
            .append("auditId", getAuditId())
            .append("drawer", getDrawer())
            .append("payee", getPayee())
            .append("financialInstitution", getFinancialInstitution())
            .append("invoiceAmount", getInvoiceAmount())
            .append("draftDate", getDraftDate())
            .append("dueDate", getDueDate())
            .append("remark", getRemark())
            .append("acceptAgreementId", getAcceptAgreementId())
            .append("entryName", getEntryName())
            .append("comment", getComment())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("rzScrList", getRzScrList())
            .toString();
    }
}
