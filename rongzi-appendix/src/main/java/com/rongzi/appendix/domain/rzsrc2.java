package com.rongzi.appendix.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.rongzi.common.annotation.Excel;
import com.rongzi.common.core.domain.BaseEntity;

/**
 * 附件表对象 rz_scr
 * 
 * @author rongzi
 * @date 2024-02-08
 */
public class rzsrc2 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 资源id主键 */
    private Long id;

    /** url地址 */
    @Excel(name = "url地址")
    private String url;

    /** 数据唯一编号 */
    @Excel(name = "数据唯一编号")
    private String scrUuid;

    /** 各个项目管理编号 */
    @Excel(name = "各个项目管理编号")
    private String projectManagementId;

    /** 种类筛选：下拉（融资项目、政府专项债、专项借款、内部借款、企业借款、对内担保、对外担保、银行承兑汇票、商业承兑汇票、信用证、反向保理、贷后管理、授信管理） */
    @Excel(name = "种类筛选：下拉", readConverterExp = "融=资项目、政府专项债、专项借款、内部借款、企业借款、对内担保、对外担保、银行承兑汇票、商业承兑汇票、信用证、反向保理、贷后管理、授信管理")
    private String type;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }
    public void setScrUuid(String scrUuid) 
    {
        this.scrUuid = scrUuid;
    }

    public String getScrUuid() 
    {
        return scrUuid;
    }
    public void setProjectManagementId(String projectManagementId) 
    {
        this.projectManagementId = projectManagementId;
    }

    public String getProjectManagementId() 
    {
        return projectManagementId;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("url", getUrl())
            .append("scrUuid", getScrUuid())
            .append("projectManagementId", getProjectManagementId())
            .append("type", getType())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .toString();
    }
}
