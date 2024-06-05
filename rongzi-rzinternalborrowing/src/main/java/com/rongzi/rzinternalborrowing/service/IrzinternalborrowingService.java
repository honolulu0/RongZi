package com.rongzi.rzinternalborrowing.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.rongzi.rzinternalborrowing.domain.rzinternalborrowing;

/**
 * 内部借款Service接口
 * 
 * @author rongzi
 * @date 2024-03-20
 */
public interface IrzinternalborrowingService 
{
    /**
     * 查询内部借款
     * 
     * @param id 内部借款主键
     * @return 内部借款
     */
    public rzinternalborrowing selectrzinternalborrowingById(Long id);

    /**
     * 查询内部借款列表
     * 
     * @param rzinternalborrowing 内部借款
     * @return 内部借款集合
     */
    public List<rzinternalborrowing> selectrzinternalborrowingList(rzinternalborrowing rzinternalborrowing);

    public Map<String, BigDecimal> selectrzinternalborrowingSum(rzinternalborrowing rzinternalborrowing);

    /**
     * 新增内部借款
     * 
     * @param rzinternalborrowing 内部借款
     * @return 结果
     */
    public int insertrzinternalborrowing(rzinternalborrowing rzinternalborrowing);

    /**
     * 修改内部借款
     * 
     * @param rzinternalborrowing 内部借款
     * @return 结果
     */
    public int updaterzinternalborrowing(rzinternalborrowing rzinternalborrowing);

    /**
     * 批量删除内部借款
     * 
     * @param ids 需要删除的内部借款主键集合
     * @return 结果
     */
    public int deleterzinternalborrowingByIds(Long[] ids);

    /**
     * 删除内部借款信息
     * 
     * @param id 内部借款主键
     * @return 结果
     */
    public int deleterzinternalborrowingById(Long id);
}
