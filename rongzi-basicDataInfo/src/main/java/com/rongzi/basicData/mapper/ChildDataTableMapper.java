package com.rongzi.basicData.mapper;

import java.util.List;
import com.rongzi.basicData.domain.ChildDataTable;

/**
 * 基本数据详情Mapper接口
 * 
 * @author rongzi
 * @date 2024-02-02
 */
public interface ChildDataTableMapper 
{
    /**
     * 查询基本数据详情
     * 
     * @param childDataId 基本数据详情主键
     * @return 基本数据详情
     */
    public ChildDataTable selectChildDataTableByChildDataId(Long childDataId);

    /**
     * 查询基本数据详情列表
     * 
     * @param childDataTable 基本数据详情
     * @return 基本数据详情集合
     */
    public List<ChildDataTable> selectChildDataTableList(ChildDataTable childDataTable);

    /**
     * 新增基本数据详情
     * 
     * @param childDataTable 基本数据详情
     * @return 结果
     */
    public int insertChildDataTable(ChildDataTable childDataTable);

    /**
     * 修改基本数据详情
     * 
     * @param childDataTable 基本数据详情
     * @return 结果
     */
    public int updateChildDataTable(ChildDataTable childDataTable);

    /**
     * 删除基本数据详情
     * 
     * @param childDataId 基本数据详情主键
     * @return 结果
     */
    public int deleteChildDataTableByChildDataId(Long childDataId);

    /**
     * 批量删除基本数据详情
     * 
     * @param childDataIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChildDataTableByChildDataIds(Long[] childDataIds);
}
