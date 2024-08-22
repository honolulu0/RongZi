package com.rongzi.reverse.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.rongzi.reverse.domain.rzreversefactoring;
import com.rongzi.appendix.domain.rzsrc2;
/**
 * 反向保理Service接口
 *
 * @author rongzi
 * @date 2024-05-30
 */
public interface IrzreversefactoringService
{
    /**
     * 查询反向保理
     *
     * @param id 反向保理主键
     * @return 反向保理
     */
    public rzreversefactoring selectrzreversefactoringById(Long id);

    /**
     * 查询反向保理列表
     *
     * @param rzreversefactoring 反向保理
     * @return 反向保理集合
     */
    public List<rzreversefactoring> selectrzreversefactoringList(rzreversefactoring rzreversefactoring);

    public Map<String, BigDecimal> selectrzreversefactoringSum(rzreversefactoring rzreversefactoring);

    /**
     * 新增反向保理
     *
     * @param rzreversefactoring 反向保理
     * @return 结果
     */
    public int insertrzreversefactoring(rzreversefactoring rzreversefactoring);

    /**
     * 修改反向保理
     *
     * @param rzreversefactoring 反向保理
     * @return 结果
     */
    public int updaterzreversefactoring(rzreversefactoring rzreversefactoring);

    /**
     * 批量删除反向保理
     *
     * @param ids 需要删除的反向保理主键集合
     * @return 结果
     */
    public int deleterzreversefactoringByIds(Long[] ids);

    /**
     * 删除反向保理信息
     *
     * @param id 反向保理主键
     * @return 结果
     */
    public int deleterzreversefactoringById(Long id);
}
