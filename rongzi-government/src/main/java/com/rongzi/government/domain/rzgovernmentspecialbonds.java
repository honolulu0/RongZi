package com.rongzi.government.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.rongzi.common.annotation.Excel;
import com.rongzi.common.core.domain.BaseEntity;
import com.rongzi.appendix.domain.rzsrc2;

/**
 * 政府专项债对象 rz_government_special_bonds
 *
 * @author rongzi
 * @date 2024-03-23
 */
public class rzgovernmentspecialbonds extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 数据唯一编号
     */
    @Excel(name = "数据唯一编号")
    private String scrUuid;

    /**
     * 债券名称
     */
    @Excel(name = "债券名称")
    private String bondName;

    /**
     * 债券发行规模
     */
    @Excel(name = "债券发行规模")
    private String bondSize;

    /**
     * 利率
     */
    @Excel(name = "利率")
    private String rate;

    /**
     * 债券发行期限
     */
    @Excel(name = "债券发行期限")
    private String bondDuration;

    /**
     * 偿还方式：先息后本
     */
    @Excel(name = "偿还方式：先息后本")
    private String repaymentMethod;

    /**
     * 专项批复金额
     */
    @Excel(name = "专项批复金额")
    private Long approvedAmount;

    /**
     * 累计到账金额
     */
    @Excel(name = "累计到账金额")
    private Long accumulatedAmountReceived;

    /**
     * 已还金额
     */
    @Excel(name = "已还金额")
    private Long repaidAmount;

    /**
     * 待还金额
     */
    @Excel(name = "待还金额")
    private Long remainingAmount;

    /**
     * 发行主体
     */
    @Excel(name = "发行主体")
    private String issuingEntity;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String comment;

    /**
     * uuid
     */
    @Excel(name = "uuid")
    private String uuid;

    /**
     * 政府专项债管理编号
     */
    @Excel(name = "政府专项债管理编号")
    private String managementId;

    /**
     * 借款日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "借款日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date loanDate;

    /**
     * 到期日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "到期日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dueDate;

    /**
     * 附件表信息
     */
    private List<rzsrc2> rzsrc2List;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setScrUuid(String scrUuid) {
        this.scrUuid = scrUuid;
    }

    public String getScrUuid() {
        return scrUuid;
    }

    public void setBondName(String bondName) {
        this.bondName = bondName;
    }

    public String getBondName() {
        return bondName;
    }

    public void setBondSize(String bondSize) {
        this.bondSize = bondSize;
    }

    public String getBondSize() {
        return bondSize;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getRate() {
        return rate;
    }

    public void setBondDuration(String bondDuration) {
        this.bondDuration = bondDuration;
    }

    public String getBondDuration() {
        return bondDuration;
    }

    public void setRepaymentMethod(String repaymentMethod) {
        this.repaymentMethod = repaymentMethod;
    }

    public String getRepaymentMethod() {
        return repaymentMethod;
    }

    public void setApprovedAmount(Long approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public Long getApprovedAmount() {
        return approvedAmount;
    }

    public void setAccumulatedAmountReceived(Long accumulatedAmountReceived) {
        this.accumulatedAmountReceived = accumulatedAmountReceived;
    }

    public Long getAccumulatedAmountReceived() {
        return accumulatedAmountReceived;
    }

    public void setRepaidAmount(Long repaidAmount) {
        this.repaidAmount = repaidAmount;
    }

    public Long getRepaidAmount() {
        return repaidAmount;
    }

    public void setRemainingAmount(Long remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public Long getRemainingAmount() {
        return remainingAmount;
    }

    public void setIssuingEntity(String issuingEntity) {
        this.issuingEntity = issuingEntity;
    }

    public String getIssuingEntity() {
        return issuingEntity;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setManagementId(String managementId) {
        this.managementId = managementId;
    }

    public String getManagementId() {
        return managementId;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public List<rzsrc2> getrzsrc2List() {
        return rzsrc2List;
    }

    public void setrzsrc2List(List<rzsrc2> rzsrc2List) {
        this.rzsrc2List = rzsrc2List;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("scrUuid", getScrUuid())
                .append("bondName", getBondName())
                .append("bondSize", getBondSize())
                .append("rate", getRate())
                .append("bondDuration", getBondDuration())
                .append("repaymentMethod", getRepaymentMethod())
                .append("approvedAmount", getApprovedAmount())
                .append("accumulatedAmountReceived", getAccumulatedAmountReceived())
                .append("repaidAmount", getRepaidAmount())
                .append("remainingAmount", getRemainingAmount())
                .append("issuingEntity", getIssuingEntity())
                .append("comment", getComment())
                .append("createTime", getCreateTime())
                .append("createBy", getCreateBy())
                .append("updateTime", getUpdateTime())
                .append("updateBy", getUpdateBy())
                .append("uuid", getUuid())
                .append("managementId", getManagementId())
                .append("loanDate", getLoanDate())
                .append("dueDate", getDueDate())
                .append("rzsrc2List", getrzsrc2List())
                .toString();
    }
}
