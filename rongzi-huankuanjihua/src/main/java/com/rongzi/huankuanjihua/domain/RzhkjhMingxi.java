package com.rongzi.huankuanjihua.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.rongzi.common.annotation.Excel;
import com.rongzi.common.core.domain.BaseEntity;

/**
 * 还款计划明细对象 rzhkjh_mingxi
 * 
 * @author rongzi
 * @date 2024-03-27
 */
public class RzhkjhMingxi extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 还款计划对应项目的管理编号 */
    @Excel(name = "还款计划对应项目的管理编号")
    private String managerId;

    /** 期数 */
    @Excel(name = "期数")
    private String qishu;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date riqi;

    /** 还款金额 */
    @Excel(name = "还款金额")
    private String huankuanjine;

    /** 偿还本金 */
    @Excel(name = "偿还本金")
    private String changhuanben;

    /** 支付利息 */
    @Excel(name = "支付利息")
    private String zhifulixi;

    /** 本金剩余 */
    @Excel(name = "本金剩余")
    private String benjinshengyu;

    /** 备注 */
    @Excel(name = "备注")
    private String comment;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setManagerId(String managerId) 
    {
        this.managerId = managerId;
    }

    public String getManagerId() 
    {
        return managerId;
    }
    public void setQishu(String qishu) 
    {
        this.qishu = qishu;
    }

    public String getQishu() 
    {
        return qishu;
    }
    public void setRiqi(Date riqi) 
    {
        this.riqi = riqi;
    }

    public Date getRiqi() 
    {
        return riqi;
    }
    public void setHuankuanjine(String huankuanjine) 
    {
        this.huankuanjine = huankuanjine;
    }

    public String getHuankuanjine() 
    {
        return huankuanjine;
    }
    public void setChanghuanben(String changhuanben) 
    {
        this.changhuanben = changhuanben;
    }

    public String getChanghuanben() 
    {
        return changhuanben;
    }
    public void setZhifulixi(String zhifulixi) 
    {
        this.zhifulixi = zhifulixi;
    }

    public String getZhifulixi() 
    {
        return zhifulixi;
    }
    public void setBenjinshengyu(String benjinshengyu) 
    {
        this.benjinshengyu = benjinshengyu;
    }

    public String getBenjinshengyu() 
    {
        return benjinshengyu;
    }
    public void setComment(String comment) 
    {
        this.comment = comment;
    }

    public String getComment() 
    {
        return comment;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("managerId", getManagerId())
            .append("qishu", getQishu())
            .append("riqi", getRiqi())
            .append("huankuanjine", getHuankuanjine())
            .append("changhuanben", getChanghuanben())
            .append("zhifulixi", getZhifulixi())
            .append("benjinshengyu", getBenjinshengyu())
            .append("comment", getComment())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
