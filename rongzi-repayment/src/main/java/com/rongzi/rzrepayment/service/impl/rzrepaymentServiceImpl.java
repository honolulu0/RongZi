package com.rongzi.rzrepayment.service.impl;

import java.util.List;
import com.rongzi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rongzi.rzrepayment.mapper.rzrepaymentMapper;
import com.rongzi.rzrepayment.domain.rzrepayment;
import com.rongzi.rzrepayment.service.IrzrepaymentService;

/**
 * 还款计划Service业务层处理
 * 
 * @author rongzi
 * @date 2024-03-01
 */
@Service
public class rzrepaymentServiceImpl implements IrzrepaymentService 
{
    @Autowired
    private rzrepaymentMapper rzrepaymentMapper;

    /**
     * 查询还款计划
     * 
     * @param id 还款计划主键
     * @return 还款计划
     */
    @Override
    public rzrepayment selectrzrepaymentById(Long id)
    {
        return rzrepaymentMapper.selectrzrepaymentById(id);
    }

    /**
     * 查询还款计划列表
     * 
     * @param rzrepayment 还款计划
     * @return 还款计划
     */
    @Override
    public List<rzrepayment> selectrzrepaymentList(rzrepayment rzrepayment)
    {
        return rzrepaymentMapper.selectrzrepaymentList(rzrepayment);
    }

    /**
     * 新增还款计划
     * 
     * @param rzrepayment 还款计划
     * @return 结果
     */
    @Override
    public int insertrzrepayment(rzrepayment rzrepayment)
    {
        rzrepayment.setCreateTime(DateUtils.getNowDate());
        return rzrepaymentMapper.insertrzrepayment(rzrepayment);
    }

    /**
     * 修改还款计划
     * 
     * @param rzrepayment 还款计划
     * @return 结果
     */
    @Override
    public int updaterzrepayment(rzrepayment rzrepayment)
    {
        rzrepayment.setUpdateTime(DateUtils.getNowDate());
        return rzrepaymentMapper.updaterzrepayment(rzrepayment);
    }

    /**
     * 批量删除还款计划
     * 
     * @param ids 需要删除的还款计划主键
     * @return 结果
     */
    @Override
    public int deleterzrepaymentByIds(Long[] ids)
    {
        return rzrepaymentMapper.deleterzrepaymentByIds(ids);
    }

    /**
     * 删除还款计划信息
     * 
     * @param id 还款计划主键
     * @return 结果
     */
    @Override
    public int deleterzrepaymentById(Long id)
    {
        return rzrepaymentMapper.deleterzrepaymentById(id);
    }
}
