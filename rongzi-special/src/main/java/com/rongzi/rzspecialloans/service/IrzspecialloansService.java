package com.rongzi.rzspecialloans.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.rongzi.rzspecialloans.domain.rzspecialloans;

/**
 * 专项借款Service接口
 * 
 * @author rongzi
 * @date 2024-03-23
 */
public interface IrzspecialloansService 
{
    /**
     * 查询专项借款
     * 
     * @param id 专项借款主键
     * @return 专项借款
     */
    public rzspecialloans selectrzspecialloansById(Long id);

    /**
     * 查询专项借款列表
     * 
     * @param rzspecialloans 专项借款
     * @return 专项借款集合
     */
    public List<rzspecialloans> selectrzspecialloansList(rzspecialloans rzspecialloans);

    public Map<String, BigDecimal> selectrzspecialloansSum(rzspecialloans rzspecialloans);

    /**
     * 新增专项借款
     * 
     * @param rzspecialloans 专项借款
     * @return 结果
     */
    public int insertrzspecialloans(rzspecialloans rzspecialloans);

    /**
     * 修改专项借款
     * 
     * @param rzspecialloans 专项借款
     * @return 结果
     */
    public int updaterzspecialloans(rzspecialloans rzspecialloans);

    /**
     * 批量删除专项借款
     * 
     * @param ids 需要删除的专项借款主键集合
     * @return 结果
     */
    public int deleterzspecialloansByIds(Long[] ids);

    /**
     * 删除专项借款信息
     * 
     * @param id 专项借款主键
     * @return 结果
     */
    public int deleterzspecialloansById(Long id);
}
