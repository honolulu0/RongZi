package com.rongzi.reverse.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.rongzi.common.annotation.Excel;
import com.rongzi.common.core.domain.BaseEntity;
import com.rongzi.appendix.domain.rzsrc2;
/**
 * 反向保理对象 rz_reverse_factoring
 *
 * @author rongzi
 * @date 2024-05-30
 */
public class rzreversefactoring extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 反向保理管理编号 */
    @Excel(name = "反向保理管理编号")
    private String managementId;

    /** 数据唯一编号 */
    @Excel(name = "数据唯一编号")
    private String scrUuid;

    /** 审核id */
    @Excel(name = "审核id")
    private Long auditId;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String creditor;

    /** 保理企业 */
    @Excel(name = "保理企业")
    private String factor;

    /** 金融机构 */
    @Excel(name = "金融机构")
    private String financialInstitution;

    /** 放贷金额 */
    @Excel(name = "放贷金额")
    private Long loanAmount;

    /** 开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 结束日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deadline;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String entryName;

    /** 回款账户名称 */
    @Excel(name = "回款账户名称")
    private String collectionAccount;

    /** 备注 */
    @Excel(name = "备注")
    private String comment;

    /** uuid */
    @Excel(name = "uuid")
    private String uuid;

    /** 账号 */
    @Excel(name = "账号")
    private String account;

    /** 开户行 */
    @Excel(name = "开户行")
    private String bank;

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
    public void setCreditor(String creditor)
    {
        this.creditor = creditor;
    }

    public String getCreditor()
    {
        return creditor;
    }
    public void setFactor(String factor)
    {
        this.factor = factor;
    }

    public String getFactor()
    {
        return factor;
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
    public void setEntryName(String entryName)
    {
        this.entryName = entryName;
    }

    public String getEntryName()
    {
        return entryName;
    }
    public void setCollectionAccount(String collectionAccount)
    {
        this.collectionAccount = collectionAccount;
    }

    public String getCollectionAccount()
    {
        return collectionAccount;
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
    public void setAccount(String account)
    {
        this.account = account;
    }

    public String getAccount()
    {
        return account;
    }
    public void setBank(String bank)
    {
        this.bank = bank;
    }

    public String getBank()
    {
        return bank;
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
                .append("creditor", getCreditor())
                .append("factor", getFactor())
                .append("financialInstitution", getFinancialInstitution())
                .append("loanAmount", getLoanAmount())
                .append("startDate", getStartDate())
                .append("deadline", getDeadline())
                .append("entryName", getEntryName())
                .append("remark", getRemark())
                .append("collectionAccount", getCollectionAccount())
                .append("comment", getComment())
                .append("createTime", getCreateTime())
                .append("createBy", getCreateBy())
                .append("updateTime", getUpdateTime())
                .append("updateBy", getUpdateBy())
                .append("uuid", getUuid())
                .append("account", getAccount())
                .append("bank", getBank())
                .append("rzsrc2List", getrzsrc2List())
                .toString();
    }
}
