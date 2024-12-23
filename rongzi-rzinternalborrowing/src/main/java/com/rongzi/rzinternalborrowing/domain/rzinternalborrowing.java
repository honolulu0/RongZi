package com.rongzi.rzinternalborrowing.domain;

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
 * 内部借款对象 rz_internal_borrowing
 *
 * @author rongzi
 * @date 2024-03-20
 */
public class rzinternalborrowing extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 内部借款管理编号
     */
    @Excel(name = "管理编号")
    private String managementId;

    /**
     * 数据唯一编号
     */
    private String scrUuid;


    @Excel(name = "类型")
    private String leixing_neibujiekuan;


    /**
     * 借款金额
     */
    @Excel(name = "借款金额")
    private Long loanAmount;


    /**
     * 本金余额
     */
    @Excel(name = "本金余额")
    private Long benjinshengyu;

    /**
     * 已还利息
     */
    @Excel(name = "已还利息")
    private Long yihuanlixi;


    /**
     * 借款方
     */
    @Excel(name = "借款方")
    private String borrower;

    /**
     * 收款方
     */
    @Excel(name = "收款方")
    private String payee;

    /**
     * 借款日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "借款日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date borrowDate;

    /**
     * 到期日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "到期日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dueDate;

    /**
     * 借款期限
     */
    @Excel(name = "借款期限")
    private String loanTerm;

    /**
     * 利率
     */
//    @Excel(name = "利率")
    private String rate;

    /**
     * 合同编号
     */
    @Excel(name = "合同编号")
    private String contractId;

    /**
     * 还款方式：先息后本
     */
    @Excel(name = "还款方式")
    private String repaymentMethod;

    /**
     * 借款用途：保交楼、城中村改造
     */
    @Excel(name = "借款用途")
    private String loanUse;

    @Excel(name = "借款状态")
    private String jiekuanzhuangtai;


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
     * 转借人
     */
    @Excel(name = "转借人")
    private String sublessee;


    /**
     * 附件表信息
     */
    private List<rzsrc2> rzsrc2List;


    /**
     * 提取本金
     */
    private String zjbj;

    /**
     * 偿还本金
     */
    private String bjch;

    /**
     * 利息偿还
     */
    private String lxch;


    public String getLeixing_neibujiekuan() {
        return leixing_neibujiekuan;
    }

    public void setLeixing_neibujiekuan(String leixing_neibujiekuan) {
        this.leixing_neibujiekuan = leixing_neibujiekuan;
    }

    public Long getBenjinshengyu() {
        return benjinshengyu;
    }

    public void setBenjinshengyu(Long benjinshengyu) {
        this.benjinshengyu = benjinshengyu;
    }

    public Long getYihuanlixi() {
        return yihuanlixi;
    }

    public void setYihuanlixi(Long yihuanlixi) {
        this.yihuanlixi = yihuanlixi;
    }

    public String getJiekuanzhuangtai() {
        return jiekuanzhuangtai;
    }

    public void setJiekuanzhuangtai(String jiekuanzhuangtai) {
        this.jiekuanzhuangtai = jiekuanzhuangtai;
    }

    public String getZjbj() {
        return zjbj;
    }

    public void setZjbj(String zjbj) {
        this.zjbj = zjbj;
    }

    public String getBjch() {
        return bjch;
    }

    public void setBjch(String bjch) {
        this.bjch = bjch;
    }

    public String getLxch() {
        return lxch;
    }

    public void setLxch(String lxch) {
        this.lxch = lxch;
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

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getPayee() {
        return payee;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setLoanTerm(String loanTerm) {
        this.loanTerm = loanTerm;
    }

    public String getLoanTerm() {
        return loanTerm;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getRate() {
        return rate;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setRepaymentMethod(String repaymentMethod) {
        this.repaymentMethod = repaymentMethod;
    }

    public String getRepaymentMethod() {
        return repaymentMethod;
    }

    public void setLoanUse(String loanUse) {
        this.loanUse = loanUse;
    }

    public String getLoanUse() {
        return loanUse;
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

    public void setSublessee(String sublessee) {
        this.sublessee = sublessee;
    }

    public String getSublessee() {
        return sublessee;
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
                .append("loanAmount", getLoanAmount())
                .append("borrower", getBorrower())
                .append("payee", getPayee())
                .append("borrowDate", getBorrowDate())
                .append("dueDate", getDueDate())
                .append("loanTerm", getLoanTerm())
                .append("rate", getRate())
                .append("contractId", getContractId())
                .append("repaymentMethod", getRepaymentMethod())
                .append("loanUse", getLoanUse())
                .append("comment", getComment())
                .append("createTime", getCreateTime())
                .append("createBy", getCreateBy())
                .append("updateTime", getUpdateTime())
                .append("updateBy", getUpdateBy())
                .append("uuid", getUuid())
                .append("sublessee", getSublessee())
                .append("rzsrc2List", getrzsrc2List())
                .append("zjbj", zjbj)
                .append("bjch", bjch)
                .append("lxch", lxch)
                .append("leixing_neibujiekuan", leixing_neibujiekuan)
                .append("benjinshengyu", benjinshengyu)
                .append("yihuanlixi", yihuanlixi)
                .append("jiekuanzhuangtai", jiekuanzhuangtai)
                .toString();
    }


}
