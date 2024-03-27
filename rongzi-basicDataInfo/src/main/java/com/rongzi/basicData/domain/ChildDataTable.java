package com.rongzi.basicData.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.rongzi.common.annotation.Excel;
import com.rongzi.common.core.domain.BaseEntity;

/**
 * 基本数据详情对象 child_data_table
 * 
 * @author rongzi
 * @date 2024-02-02
 */
public class ChildDataTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 子信息id主键 */
    private Long childDataId;

    /** 基本信息id外键 */
    @Excel(name = "基本信息id外键")
    private Long basicDataId;

    /** 子信息名称 */
    @Excel(name = "子信息名称")
    private String childName;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date childCreateTime;

    /** 创建人 */
    @Excel(name = "创建人")
    private String childCreatedBy;

    public void setChildDataId(Long childDataId) 
    {
        this.childDataId = childDataId;
    }

    public Long getChildDataId() 
    {
        return childDataId;
    }
    public void setBasicDataId(Long basicDataId) 
    {
        this.basicDataId = basicDataId;
    }

    public Long getBasicDataId() 
    {
        return basicDataId;
    }
    public void setChildName(String childName) 
    {
        this.childName = childName;
    }

    public String getChildName() 
    {
        return childName;
    }
    public void setChildCreateTime(Date childCreateTime) 
    {
        this.childCreateTime = childCreateTime;
    }

    public Date getChildCreateTime() 
    {
        return childCreateTime;
    }
    public void setChildCreatedBy(String childCreatedBy) 
    {
        this.childCreatedBy = childCreatedBy;
    }

    public String getChildCreatedBy() 
    {
        return childCreatedBy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("childDataId", getChildDataId())
            .append("basicDataId", getBasicDataId())
            .append("childName", getChildName())
            .append("childCreateTime", getChildCreateTime())
            .append("childCreatedBy", getChildCreatedBy())
            .toString();
    }
}
