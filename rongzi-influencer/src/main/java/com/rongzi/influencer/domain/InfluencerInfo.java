package com.rongzi.influencer.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.rongzi.common.annotation.Excel;
import com.rongzi.common.core.domain.BaseEntity;

/**
 * 红人对象 influencer_info
 * 
 * @author rongzi
 * @date 2023-07-26
 */
public class InfluencerInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 红人编号 */
    @Excel(name = "红人编号")
    private Long uid;

    /** 站点 */
    @Excel(name = "站点")
    private String site;

    /** 红人名称 */
    @Excel(name = "红人名称")
    private String name;

    /** 红人类型 */
    @Excel(name = "红人类型")
    private String type;

    /** 业务线 */
    @Excel(name = "业务线")
    private String lineOfBusiness;

    /** Profile Link */
    @Excel(name = "Profile Link")
    private String profileLink;

    /** 头像 */
    @Excel(name = "头像")
    private String avatar;

    /** Banner */
    @Excel(name = "Banner")
    private String banner;

    /** influencer 报价 */
    @Excel(name = "influencer 报价")
    private BigDecimal influencerCommission;

    /** influencer 报价百分比 */
    @Excel(name = "influencer 报价百分比")
    private BigDecimal influencerCommissionPercentage;

    /** 版权佣金 */
    @Excel(name = "版权佣金")
    private BigDecimal copyrightCommission;

    /** 版权佣金百分比 */
    @Excel(name = "版权佣金百分比")
    private BigDecimal copyrightCommissionPercentage;

    /** Video 佣金 */
    @Excel(name = "Video 佣金")
    private BigDecimal vdeoCommission;

    /** Video 佣金百分比 */
    @Excel(name = "Video 佣金百分比")
    private BigDecimal vdeoCommissionPercentage;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUid(Long uid) 
    {
        this.uid = uid;
    }

    public Long getUid() 
    {
        return uid;
    }
    public void setSite(String site) 
    {
        this.site = site;
    }

    public String getSite() 
    {
        return site;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setLineOfBusiness(String lineOfBusiness) 
    {
        this.lineOfBusiness = lineOfBusiness;
    }

    public String getLineOfBusiness() 
    {
        return lineOfBusiness;
    }
    public void setProfileLink(String profileLink) 
    {
        this.profileLink = profileLink;
    }

    public String getProfileLink() 
    {
        return profileLink;
    }
    public void setAvatar(String avatar) 
    {
        this.avatar = avatar;
    }

    public String getAvatar() 
    {
        return avatar;
    }
    public void setBanner(String banner) 
    {
        this.banner = banner;
    }

    public String getBanner() 
    {
        return banner;
    }
    public void setInfluencerCommission(BigDecimal influencerCommission) 
    {
        this.influencerCommission = influencerCommission;
    }

    public BigDecimal getInfluencerCommission() 
    {
        return influencerCommission;
    }
    public void setInfluencerCommissionPercentage(BigDecimal influencerCommissionPercentage) 
    {
        this.influencerCommissionPercentage = influencerCommissionPercentage;
    }

    public BigDecimal getInfluencerCommissionPercentage() 
    {
        return influencerCommissionPercentage;
    }
    public void setCopyrightCommission(BigDecimal copyrightCommission) 
    {
        this.copyrightCommission = copyrightCommission;
    }

    public BigDecimal getCopyrightCommission() 
    {
        return copyrightCommission;
    }
    public void setCopyrightCommissionPercentage(BigDecimal copyrightCommissionPercentage) 
    {
        this.copyrightCommissionPercentage = copyrightCommissionPercentage;
    }

    public BigDecimal getCopyrightCommissionPercentage() 
    {
        return copyrightCommissionPercentage;
    }
    public void setVdeoCommission(BigDecimal vdeoCommission) 
    {
        this.vdeoCommission = vdeoCommission;
    }

    public BigDecimal getVdeoCommission() 
    {
        return vdeoCommission;
    }
    public void setVdeoCommissionPercentage(BigDecimal vdeoCommissionPercentage) 
    {
        this.vdeoCommissionPercentage = vdeoCommissionPercentage;
    }

    public BigDecimal getVdeoCommissionPercentage() 
    {
        return vdeoCommissionPercentage;
    }
    public void setCreatTime(Date creatTime) 
    {
        this.creatTime = creatTime;
    }

    public Date getCreatTime() 
    {
        return creatTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uid", getUid())
            .append("site", getSite())
            .append("name", getName())
            .append("type", getType())
            .append("lineOfBusiness", getLineOfBusiness())
            .append("profileLink", getProfileLink())
            .append("avatar", getAvatar())
            .append("banner", getBanner())
            .append("influencerCommission", getInfluencerCommission())
            .append("influencerCommissionPercentage", getInfluencerCommissionPercentage())
            .append("copyrightCommission", getCopyrightCommission())
            .append("copyrightCommissionPercentage", getCopyrightCommissionPercentage())
            .append("vdeoCommission", getVdeoCommission())
            .append("vdeoCommissionPercentage", getVdeoCommissionPercentage())
            .append("creatTime", getCreatTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
