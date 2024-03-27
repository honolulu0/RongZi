package com.rongzi.rzauditlist.service.impl;

import java.util.List;
import com.rongzi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rongzi.rzauditlist.mapper.rzauditlistMapper;
import com.rongzi.rzauditlist.domain.rzauditlist;
import com.rongzi.rzauditlist.service.IrzauditlistService;

/**
 * 审核项目Service业务层处理
 * 
 * @author rongzi
 * @date 2024-02-19
 */
@Service
public class rzauditlistServiceImpl implements IrzauditlistService 
{
    @Autowired
    private rzauditlistMapper rzauditlistMapper;

    /**
     * 查询审核项目
     * 
     * @param id 审核项目主键
     * @return 审核项目
     */
    @Override
    public rzauditlist selectrzauditlistById(Long id)
    {
        return rzauditlistMapper.selectrzauditlistById(id);
    }

    /**
     * 查询审核项目列表
     * 
     * @param rzauditlist 审核项目
     * @return 审核项目
     */
    @Override
    public List<rzauditlist> selectrzauditlistList(rzauditlist rzauditlist)
    {
        return rzauditlistMapper.selectrzauditlistList(rzauditlist);
    }

    /**
     * 新增审核项目
     * 
     * @param rzauditlist 审核项目
     * @return 结果
     */
    @Override
    public int insertrzauditlist(rzauditlist rzauditlist)
    {
        rzauditlist.setCreateTime(DateUtils.getNowDate());
        return rzauditlistMapper.insertrzauditlist(rzauditlist);
    }

    /**
     * 修改审核项目
     * 
     * @param rzauditlist 审核项目
     * @return 结果
     */
    @Override
    public int updaterzauditlist(rzauditlist rzauditlist)
    {
        return rzauditlistMapper.updaterzauditlist(rzauditlist);
    }

    /**
     * 批量删除审核项目
     * 
     * @param ids 需要删除的审核项目主键
     * @return 结果
     */
    @Override
    public int deleterzauditlistByIds(Long[] ids)
    {
        return rzauditlistMapper.deleterzauditlistByIds(ids);
    }

    /**
     * 删除审核项目信息
     * 
     * @param id 审核项目主键
     * @return 结果
     */
    @Override
    public int deleterzauditlistById(Long id)
    {
        return rzauditlistMapper.deleterzauditlistById(id);
    }
}
