package com.rongzi.rzrepayment.service;

import java.util.List;
import com.rongzi.rzrepayment.domain.rzrepayment;

/**
 * 还款计划Service接口
 * 
 * @author rongzi
 * @date 2024-03-01
 */
public interface IrzrepaymentService 
{
    /**
     * 查询还款计划
     * 
     * @param id 还款计划主键
     * @return 还款计划
     */
    public rzrepayment selectrzrepaymentById(Long id);

    /**
     * 查询还款计划列表
     * 
     * @param rzrepayment 还款计划
     * @return 还款计划集合
     */
    public List<rzrepayment> selectrzrepaymentList(rzrepayment rzrepayment);

    /**
     * 新增还款计划
     * 
     * @param rzrepayment 还款计划
     * @return 结果
     */
    public int insertrzrepayment(rzrepayment rzrepayment);

    /**
     * 修改还款计划
     * 
     * @param rzrepayment 还款计划
     * @return 结果
     */
    public int updaterzrepayment(rzrepayment rzrepayment);

    /**
     * 批量删除还款计划
     * 
     * @param ids 需要删除的还款计划主键集合
     * @return 结果
     */
    public int deleterzrepaymentByIds(Long[] ids);

    /**
     * 删除还款计划信息
     * 
     * @param id 还款计划主键
     * @return 结果
     */
    public int deleterzrepaymentById(Long id);
}
