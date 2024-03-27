package com.rongzi.basicData.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rongzi.basicData.mapper.ChildDataTableMapper;
import com.rongzi.basicData.domain.ChildDataTable;
import com.rongzi.basicData.service.IChildDataTableService;

/**
 * 基本数据详情Service业务层处理
 * 
 * @author rongzi
 * @date 2024-02-02
 */
@Service
public class ChildDataTableServiceImpl implements IChildDataTableService 
{
    @Autowired
    private ChildDataTableMapper childDataTableMapper;

    /**
     * 查询基本数据详情
     * 
     * @param childDataId 基本数据详情主键
     * @return 基本数据详情
     */
    @Override
    public ChildDataTable selectChildDataTableByChildDataId(Long childDataId)
    {
        return childDataTableMapper.selectChildDataTableByChildDataId(childDataId);
    }

    /**
     * 查询基本数据详情列表
     * 
     * @param childDataTable 基本数据详情
     * @return 基本数据详情
     */
    @Override
    public List<ChildDataTable> selectChildDataTableList(ChildDataTable childDataTable)
    {
        return childDataTableMapper.selectChildDataTableList(childDataTable);
    }

    /**
     * 新增基本数据详情
     * 
     * @param childDataTable 基本数据详情
     * @return 结果
     */
    @Override
    public int insertChildDataTable(ChildDataTable childDataTable)
    {
        return childDataTableMapper.insertChildDataTable(childDataTable);
    }

    /**
     * 修改基本数据详情
     * 
     * @param childDataTable 基本数据详情
     * @return 结果
     */
    @Override
    public int updateChildDataTable(ChildDataTable childDataTable)
    {
        return childDataTableMapper.updateChildDataTable(childDataTable);
    }

    /**
     * 批量删除基本数据详情
     * 
     * @param childDataIds 需要删除的基本数据详情主键
     * @return 结果
     */
    @Override
    public int deleteChildDataTableByChildDataIds(Long[] childDataIds)
    {
        return childDataTableMapper.deleteChildDataTableByChildDataIds(childDataIds);
    }

    /**
     * 删除基本数据详情信息
     * 
     * @param childDataId 基本数据详情主键
     * @return 结果
     */
    @Override
    public int deleteChildDataTableByChildDataId(Long childDataId)
    {
        return childDataTableMapper.deleteChildDataTableByChildDataId(childDataId);
    }
}
