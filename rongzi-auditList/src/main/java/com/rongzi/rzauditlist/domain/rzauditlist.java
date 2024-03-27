package com.rongzi.rzauditlist.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.rongzi.common.annotation.Excel;
import com.rongzi.common.core.domain.BaseEntity;

/**
 * 审核项目对象 rz_audit_list
 *
 * @author rongzi
 * @date 2024-03-25
 */
public class rzauditlist extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 审核id */
    @Excel(name = "审核id")
    private Long auditId;

    /** 数据唯一编号,所有添加和修改的数据,都先存到这个表里,如果有uuid+审核状态是 待审批 的,就提示"等待上次审核完成后,再提交新的修改",审核通过之后再通过uuid和表名,去调用各自的接口,保存到最终的表里.关于uuid的更新时机,添加时,默认新生成uuid,修改时,使用旧uuid,审核通过去保存时,生成新的uuid保存回去. */
    @Excel(name = "数据唯一编号,所有添加和修改的数据,都先存到这个表里,如果有uuid+审核状态是 待审批 的,就提示'等待上次审核完成后,再提交新的修改',审核通过之后再通过uuid和表名,去调用各自的接口,保存到最终的表里.关于uuid的更新时机,添加时,默认新生成uuid,修改时,使用旧uuid,审核通过去保存时,生成新的uuid保存回去.")
    private String uuid;

    /** 数据json文件 */
    @Excel(name = "数据json文件")
    private String dataJson;

    /** 父级表名 */
    @Excel(name = "父级表名")
    private String tableName;

    /** 审核状态：待审批、审批不通过、审批通过、已撤回,只有 待审批状态不能提交新的审核 */
    @Excel(name = "审核状态：待审批、审批不通过、审批通过、已撤回,只有 待审批状态不能提交新的审核")
    private String auditState;

    /** 管理编号 */
    @Excel(name = "管理编号")
    private String managementId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setAuditId(Long auditId)
    {
        this.auditId = auditId;
    }

    public Long getAuditId()
    {
        return auditId;
    }
    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    public String getUuid()
    {
        return uuid;
    }
    public void setDataJson(String dataJson)
    {
        this.dataJson = dataJson;
    }

    public String getDataJson()
    {
        return dataJson;
    }
    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    public String getTableName()
    {
        return tableName;
    }
    public void setAuditState(String auditState)
    {
        this.auditState = auditState;
    }

    public String getAuditState()
    {
        return auditState;
    }
    public void setManagementId(String managementId)
    {
        this.managementId = managementId;
    }

    public String getManagementId()
    {
        return managementId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("auditId", getAuditId())
                .append("uuid", getUuid())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("dataJson", getDataJson())
                .append("tableName", getTableName())
                .append("auditState", getAuditState())
                .append("managementId", getManagementId())
                .toString();
    }
}
