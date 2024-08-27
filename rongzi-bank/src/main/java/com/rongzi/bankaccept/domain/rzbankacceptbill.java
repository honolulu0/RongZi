package com.rongzi.bankaccept.domain;

import java.util.List;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rongzi.huankuanjihua.domain.RzhkjhMingxi;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.rongzi.common.annotation.Excel;
import com.rongzi.common.core.domain.BaseEntity;
import com.rongzi.appendix.domain.rzsrc2;

/**
 * 银行承兑汇票对象 rz_bank_accept_bill
 *
 * @author rongzi
 * @date 2024-05-30
 */
public class rzbankacceptbill extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;

    /**
     * 银行承兑管理编号
     */
    @Excel(name = "管理编号")
    private String managementId;

    /**
     * 数据唯一编号
     */
    //@Excel(name = "数据唯一编号")
    private String scrUuid;

    /**
     * 审核id
     */
    @Excel(name = "审核id")
    private Long auditId;

    /**
     * 出票人
     */
    @Excel(name = "出票人")
    private String drawer;

    /**
     * 收票人
     */
    @Excel(name = "收票人")
    private String payee;

    /**
     * 金融机构
     */
    @Excel(name = "金融机构")
    private String financialInstitution;

    /**
     * 出票金额
     */
    @Excel(name = "出票金额", cellType = Excel.ColumnType.BIGINT, scale = 2)
    private Long invoiceAmount;

    /**
     * 出票日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出票日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date draftDate;

    /**
     * 到期日
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "到期日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dueDate;

    /**
     * 协议编号
     */
    @Excel(name = "协议编号")
    private String acceptAgreementId;

    /**
     * 项目名称
     */
    @Excel(name = "项目名称")
    private String entryName;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String comment;

    /**
     * uuid
     */

    private String uuid;

    /**
     * 出票手续费
     */
    @Excel(name = "出票手续费", cellType = Excel.ColumnType.BIGINT, scale = 2)
    private String ticketProcessingFee;

    /**
     * 保证金比例
     */
//    @Excel(name = "保证金比例")
    private String marginLevel;

    /**
     * 保证金利率
     */
//    @Excel(name = "保证金利率")
    private String marginInterestRate;

    /**
     * 保证金收益金额
     */
    @Excel(name = "保证金收益金额", cellType = Excel.ColumnType.BIGINT, scale = 2)
    private String marginIncomeAmount;

    /**
     * 是否已贴现
     */
    @Excel(name = "是否已贴现")
    private String discountedOrNot;

    /**
     * 贴现金融机构
     */
    @Excel(name = "贴现金融机构")
    private String discountedFinancialInstitutions;

    /**
     * 贴现手续费
     */
    @Excel(name = "贴现手续费", cellType = Excel.ColumnType.BIGINT, scale = 2)
    private String discountedHandlingFee;

    /**
     * 贴现费用承担情况
     */
    @Excel(name = "贴现费用承担情况")
    private String assumptionOfDiscountFees;


    /**
     * 支付利息
     */
    @Excel(name = "支付利息", cellType = Excel.ColumnType.BIGINT, scale = 2)
    private Long zhifulixi;

    /**
     * 敞口额度,出票金额×（1-保证金比例）
     */
    @Excel(name = "敞口额度", cellType = Excel.ColumnType.BIGINT, scale = 2)
    private Long changkouedu;

    /**
     * 贴现利率
     */
//    @Excel(name = "贴现利率")
    private String tiexianlilv;

    /**
     * 资金用途
     */
    @Excel(name = "资金用途")
    private String zijinyongtu;

    /**
     * 附件表信息
     */
    private List<rzsrc2> rzsrc2List;

    /**
     * 还款明细
     */
    private List<RzhkjhMingxi> huankuanmingxi2List;

    public List<RzhkjhMingxi> getHuankuanmingxi2List() {
        return huankuanmingxi2List;
    }

    public void setHuankuanmingxi2List(List<RzhkjhMingxi> huankuanmingxi2List) {
        this.huankuanmingxi2List = huankuanmingxi2List;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setManagementId(String managementId) {
        this.managementId = managementId;
    }

    public String getManagementId() {
        return managementId;
    }

    public void setScrUuid(String scrUuid) {
        this.scrUuid = scrUuid;
    }

    public String getScrUuid() {
        return scrUuid;
    }

    public void setAuditId(Long auditId) {
        this.auditId = auditId;
    }

    public Long getAuditId() {
        return auditId;
    }

    public void setDrawer(String drawer) {
        this.drawer = drawer;
    }

    public String getDrawer() {
        return drawer;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getPayee() {
        return payee;
    }

    public void setFinancialInstitution(String financialInstitution) {
        this.financialInstitution = financialInstitution;
    }

    public String getFinancialInstitution() {
        return financialInstitution;
    }

    public void setInvoiceAmount(Long invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public Long getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setDraftDate(Date draftDate) {
        this.draftDate = draftDate;
    }

    public Date getDraftDate() {
        return draftDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setAcceptAgreementId(String acceptAgreementId) {
        this.acceptAgreementId = acceptAgreementId;
    }

    public String getAcceptAgreementId() {
        return acceptAgreementId;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public String getEntryName() {
        return entryName;
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

    public void setTicketProcessingFee(String ticketProcessingFee) {
        this.ticketProcessingFee = ticketProcessingFee;
    }

    public String getTicketProcessingFee() {
        return ticketProcessingFee;
    }

    public void setMarginLevel(String marginLevel) {
        this.marginLevel = marginLevel;
    }

    public String getMarginLevel() {
        return marginLevel;
    }

    public void setMarginInterestRate(String marginInterestRate) {
        this.marginInterestRate = marginInterestRate;
    }

    public String getMarginInterestRate() {
        return marginInterestRate;
    }

    public void setMarginIncomeAmount(String marginIncomeAmount) {
        this.marginIncomeAmount = marginIncomeAmount;
    }

    public String getMarginIncomeAmount() {
        return marginIncomeAmount;
    }

    public void setDiscountedOrNot(String discountedOrNot) {
        this.discountedOrNot = discountedOrNot;
    }

    public String getDiscountedOrNot() {
        return discountedOrNot;
    }

    public void setDiscountedFinancialInstitutions(String discountedFinancialInstitutions) {
        this.discountedFinancialInstitutions = discountedFinancialInstitutions;
    }

    public String getDiscountedFinancialInstitutions() {
        return discountedFinancialInstitutions;
    }

    public void setDiscountedHandlingFee(String discountedHandlingFee) {
        this.discountedHandlingFee = discountedHandlingFee;
    }

    public String getDiscountedHandlingFee() {
        return discountedHandlingFee;
    }

    public void setAssumptionOfDiscountFees(String assumptionOfDiscountFees) {
        this.assumptionOfDiscountFees = assumptionOfDiscountFees;
    }

    public String getAssumptionOfDiscountFees() {
        return assumptionOfDiscountFees;
    }


    public void setZhifulixi(Long zhifulixi) {
        this.zhifulixi = zhifulixi;
    }

    public Long getZhifulixi() {
        return zhifulixi;
    }

    public void setChangkouedu(Long changkouedu) {
        this.changkouedu = changkouedu;
    }

    public Long getChangkouedu() {
        return changkouedu;
    }

    public void setTiexianlilv(String tiexianlilv) {
        this.tiexianlilv = tiexianlilv;
    }

    public String getTiexianlilv() {
        return tiexianlilv;
    }

    public void setZijinyongtu(String zijinyongtu) {
        this.zijinyongtu = zijinyongtu;
    }

    public String getZijinyongtu() {
        return zijinyongtu;
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
                .append("uuid", getUuid())
                .append("ticketProcessingFee", getTicketProcessingFee())
                .append("marginLevel", getMarginLevel())
                .append("marginInterestRate", getMarginInterestRate())
                .append("marginIncomeAmount", getMarginIncomeAmount())
                .append("discountedOrNot", getDiscountedOrNot())
                .append("discountedFinancialInstitutions", getDiscountedFinancialInstitutions())
                .append("discountedHandlingFee", getDiscountedHandlingFee())
                .append("assumptionOfDiscountFees", getAssumptionOfDiscountFees())
                .append("zhifulixi", getZhifulixi())
                .append("changkouedu", getChangkouedu())
                .append("tiexianlilv", getTiexianlilv())
                .append("zijinyongtu", getZijinyongtu())
                .append("rzsrc2List", getrzsrc2List())
                .toString();
    }
}
