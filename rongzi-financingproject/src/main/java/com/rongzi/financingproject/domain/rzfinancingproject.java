package com.rongzi.financingproject.domain;

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
 * 融资项目对象 rz_financing_project
 *
 * @author rongzi
 * @date 2024-05-28
 */
public class rzfinancingproject extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 管理编号
     */
    @Excel(name = "管理编号")
    private String managementId;

    /**
     * 数据唯一编号
     */
    private String scrUuid;

    /**
     * 借款人
     */
    @Excel(name = "借款人")
    private String borrowingUnit;

    /**
     * 债权人
     */
    @Excel(name = "债权人")
    private String financialInstitution;

    /**
     * 授信金额
     */
    @Excel(name = "授信金额")
    private String shouxinjine;


    /**
     * 融资类型
     */
    @Excel(name = "融资类型")
    private String financingType;

    /**
     * 融资金额
     */
    @Excel(name = "融资金额", cellType = Excel.ColumnType.BIGINT, scale = 2)
    private Long financingAmount;

    /**
     * 贷款用途
     */
    @Excel(name = "贷款用途")
    private String daikuanyongtu;

    /**
     * 合同编号
     */
    private String contractId;

    /**
     * 合同签订日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date contractSigningDate;

    /**
     * 放款日
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "放款日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date loanDate;

    /**
     * 到期日
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "到期日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dueDate;

    /**
     * 年利率
     */
//    @Excel(name = "年利率")
    private String rate;

    /**
     * 借款期限
     */
    private String loanTerm;

    /**
     * 增信措施
     */
    private String creditEnhancementMeasures;

    /**
     * 已还金额
     */
    private Long repaidAmount;

    /**
     * 融资余额
     */
    @Excel(name = "融资余额", cellType = Excel.ColumnType.BIGINT, scale = 2)
    private Long remainingAmount;

    /**
     * 保证金
     */
    @Excel(name = "保证金")
    private Long baozhengjin;

    /**
     * 手续费
     */
    @Excel(name = "手续费")
    private Long shouxufei;

    /**
     * 债务状态
     */
    @Excel(name = "债务状态")
    private String loanState;

    /**
     * 资金用途
     */
    @Excel(name = "资金用途")
    private String zijinyongtu;

    /**
     * 担保措施
     */
    @Excel(name = "担保措施")
    private String danbaocuoshi;

    /**
     * 还贷账户名称
     */
    @Excel(name = "还贷账户名称")
    private String hdzhanghumingcheng;

    /**
     * 还贷账号
     */
    @Excel(name = "还贷账号")
    private String hdzhanghao;

    /**
     * 还贷开户行
     */
    @Excel(name = "还贷开户行")
    private String hdkaihuhang;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String comment;

    /**
     * 授信管理编号
     */
//    @Excel(name = "授信管理编号")
    private String sxManagementId;

    /**
     * uuid
     */
    private String uuid;

    /**
     * 本金偿还方式
     */
    @Excel(name = "本金偿还方式")
    private String principalRepaymentMethod;

    /**
     * 利息偿还方式
     */
    @Excel(name = "利息偿还方式")
    private String interestRepaymentMethod;

    /**
     * 是否固定利率
     */
    @Excel(name = "是否固定利率")
    private String rateType;

    /**
     * 首次还款时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "首次还款时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date firstRepaymentDate;

    /**
     * 是否有还款计划
     */
    @Excel(name = "是否有还款计划")
    private String hasRepaymentPlan;

    /**
     * 提取本金
     */
    private String tiqubenjin;

    /**
     * 偿还本金
     */
    private String changhuanbenjin;

    /**
     * 利率变更
     */
    private String lilvbiangeng;

    /**
     * 利息偿还
     */
    private String lixichanghuan;

    /**
     * 附件表信息
     */
    private List<rzsrc2> rzsrc2List;


    /**
     * 还款明细
     */
    private List<RzhkjhMingxi> huankuanmingxi2List;


    /** 手续费缴纳记录 */
    private String zjywjnjl;


    public String getZjywjnjl() {
        return zjywjnjl;
    }

    public void setZjywjnjl(String zjywjnjl) {
        this.zjywjnjl = zjywjnjl;
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

    public void setBorrowingUnit(String borrowingUnit) {
        this.borrowingUnit = borrowingUnit;
    }

    public String getBorrowingUnit() {
        return borrowingUnit;
    }

    public void setFinancialInstitution(String financialInstitution) {
        this.financialInstitution = financialInstitution;
    }

    public String getFinancialInstitution() {
        return financialInstitution;
    }

    public void setShouxinjine(String shouxinjine) {
        this.shouxinjine = shouxinjine;
    }

    public String getShouxinjine() {
        return shouxinjine;
    }

    public void setFinancingAmount(Long financingAmount) {
        this.financingAmount = financingAmount;
    }

    public Long getFinancingAmount() {
        return financingAmount;
    }

    public void setFinancingType(String financingType) {
        this.financingType = financingType;
    }

    public String getFinancingType() {
        return financingType;
    }

    public void setDaikuanyongtu(String daikuanyongtu) {
        this.daikuanyongtu = daikuanyongtu;
    }

    public String getDaikuanyongtu() {
        return daikuanyongtu;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractSigningDate(Date contractSigningDate) {
        this.contractSigningDate = contractSigningDate;
    }

    public Date getContractSigningDate() {
        return contractSigningDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getRate() {
        return rate;
    }

    public void setLoanTerm(String loanTerm) {
        this.loanTerm = loanTerm;
    }

    public String getLoanTerm() {
        return loanTerm;
    }

    public void setCreditEnhancementMeasures(String creditEnhancementMeasures) {
        this.creditEnhancementMeasures = creditEnhancementMeasures;
    }

    public String getCreditEnhancementMeasures() {
        return creditEnhancementMeasures;
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

    public void setBaozhengjin(Long baozhengjin) {
        this.baozhengjin = baozhengjin;
    }

    public Long getBaozhengjin() {
        return baozhengjin;
    }

    public void setShouxufei(Long shouxufei) {
        this.shouxufei = shouxufei;
    }

    public Long getShouxufei() {
        return shouxufei;
    }

    public void setLoanState(String loanState) {
        this.loanState = loanState;
    }

    public String getLoanState() {
        return loanState;
    }

    public void setZijinyongtu(String zijinyongtu) {
        this.zijinyongtu = zijinyongtu;
    }

    public String getZijinyongtu() {
        return zijinyongtu;
    }

    public void setDanbaocuoshi(String danbaocuoshi) {
        this.danbaocuoshi = danbaocuoshi;
    }

    public String getDanbaocuoshi() {
        return danbaocuoshi;
    }

    public void setHdzhanghumingcheng(String hdzhanghumingcheng) {
        this.hdzhanghumingcheng = hdzhanghumingcheng;
    }

    public String getHdzhanghumingcheng() {
        return hdzhanghumingcheng;
    }

    public void setHdzhanghao(String hdzhanghao) {
        this.hdzhanghao = hdzhanghao;
    }

    public String getHdzhanghao() {
        return hdzhanghao;
    }

    public void setHdkaihuhang(String hdkaihuhang) {
        this.hdkaihuhang = hdkaihuhang;
    }

    public String getHdkaihuhang() {
        return hdkaihuhang;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setSxManagementId(String sxManagementId) {
        this.sxManagementId = sxManagementId;
    }

    public String getSxManagementId() {
        return sxManagementId;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setPrincipalRepaymentMethod(String principalRepaymentMethod) {
        this.principalRepaymentMethod = principalRepaymentMethod;
    }

    public String getPrincipalRepaymentMethod() {
        return principalRepaymentMethod;
    }

    public void setInterestRepaymentMethod(String interestRepaymentMethod) {
        this.interestRepaymentMethod = interestRepaymentMethod;
    }

    public String getInterestRepaymentMethod() {
        return interestRepaymentMethod;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public String getRateType() {
        return rateType;
    }

    public void setFirstRepaymentDate(Date firstRepaymentDate) {
        this.firstRepaymentDate = firstRepaymentDate;
    }

    public Date getFirstRepaymentDate() {
        return firstRepaymentDate;
    }

    public void setHasRepaymentPlan(String hasRepaymentPlan) {
        this.hasRepaymentPlan = hasRepaymentPlan;
    }

    public String getHasRepaymentPlan() {
        return hasRepaymentPlan;
    }

    public void setTiqubenjin(String tiqubenjin) {
        this.tiqubenjin = tiqubenjin;
    }

    public String getTiqubenjin() {
        return tiqubenjin;
    }

    public void setChanghuanbenjin(String changhuanbenjin) {
        this.changhuanbenjin = changhuanbenjin;
    }

    public String getChanghuanbenjin() {
        return changhuanbenjin;
    }

    public void setLilvbiangeng(String lilvbiangeng) {
        this.lilvbiangeng = lilvbiangeng;
    }

    public String getLilvbiangeng() {
        return lilvbiangeng;
    }

    public void setLixichanghuan(String lixichanghuan) {
        this.lixichanghuan = lixichanghuan;
    }

    public String getLixichanghuan() {
        return lixichanghuan;
    }

    public List<rzsrc2> getrzsrc2List() {
        return rzsrc2List;
    }

    public void setrzsrc2List(List<rzsrc2> rzsrc2List) {
        this.rzsrc2List = rzsrc2List;
    }

    public List<RzhkjhMingxi> getHuankuanmingxi2List() {
        return huankuanmingxi2List;
    }


    public void setHuankuanmingxi2List(List<RzhkjhMingxi> huankuanmingxi2List) {
        this.huankuanmingxi2List = huankuanmingxi2List;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("managementId", getManagementId())
                .append("scrUuid", getScrUuid())
                .append("borrowingUnit", getBorrowingUnit())
                .append("financialInstitution", getFinancialInstitution())
                .append("shouxinjine", getShouxinjine())
                .append("financingAmount", getFinancingAmount())
                .append("financingType", getFinancingType())
                .append("daikuanyongtu", getDaikuanyongtu())
                .append("contractId", getContractId())
                .append("contractSigningDate", getContractSigningDate())
                .append("loanDate", getLoanDate())
                .append("dueDate", getDueDate())
                .append("rate", getRate())
                .append("loanTerm", getLoanTerm())
                .append("creditEnhancementMeasures", getCreditEnhancementMeasures())
                .append("repaidAmount", getRepaidAmount())
                .append("remainingAmount", getRemainingAmount())
                .append("baozhengjin", getBaozhengjin())
                .append("shouxufei", getShouxufei())
                .append("loanState", getLoanState())
                .append("zijinyongtu", getZijinyongtu())
                .append("danbaocuoshi", getDanbaocuoshi())
                .append("hdzhanghumingcheng", getHdzhanghumingcheng())
                .append("hdzhanghao", getHdzhanghao())
                .append("hdkaihuhang", getHdkaihuhang())
                .append("comment", getComment())
                .append("sxManagementId", getSxManagementId())
                .append("createTime", getCreateTime())
                .append("createBy", getCreateBy())
                .append("updateTime", getUpdateTime())
                .append("updateBy", getUpdateBy())
                .append("uuid", getUuid())
                .append("principalRepaymentMethod", getPrincipalRepaymentMethod())
                .append("interestRepaymentMethod", getInterestRepaymentMethod())
                .append("rateType", getRateType())
                .append("firstRepaymentDate", getFirstRepaymentDate())
                .append("hasRepaymentPlan", getHasRepaymentPlan())
                .append("tiqubenjin", getTiqubenjin())
                .append("changhuanbenjin", getChanghuanbenjin())
                .append("lilvbiangeng", getLilvbiangeng())
                .append("lixichanghuan", getLixichanghuan())
                .append("rzsrc2List", getrzsrc2List())
                .append("zjywjnjl", getZjywjnjl())
                .toString();
    }
}
