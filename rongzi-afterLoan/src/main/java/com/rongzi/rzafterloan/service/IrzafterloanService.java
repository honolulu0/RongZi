package com.rongzi.rzafterloan.service;

import java.util.List;
import com.rongzi.rzafterloan.domain.rzafterloan;

/**
 * 贷后管理Service接口
 * 
 * @author rongzi
 * @date 2024-03-20
 */
public interface IrzafterloanService 
{
    /**
     * 查询贷后管理
     * 
     * @param id 贷后管理主键
     * @return 贷后管理
     */
    public rzafterloan selectrzafterloanById(Long id);

    /**
     * 查询贷后管理列表
     * 
     * @param rzafterloan 贷后管理
     * @return 贷后管理集合
     */
    public List<rzafterloan> selectrzafterloanList(rzafterloan rzafterloan);

    /**
     * 新增贷后管理
     * 
     * @param rzafterloan 贷后管理
     * @return 结果
     */
    public int insertrzafterloan(rzafterloan rzafterloan);

    /**
     * 修改贷后管理
     * 
     * @param rzafterloan 贷后管理
     * @return 结果
     */
    public int updaterzafterloan(rzafterloan rzafterloan);

    /**
     * 批量删除贷后管理
     * 
     * @param ids 需要删除的贷后管理主键集合
     * @return 结果
     */
    public int deleterzafterloanByIds(Long[] ids);

    /**
     * 删除贷后管理信息
     * 
     * @param id 贷后管理主键
     * @return 结果
     */
    public int deleterzafterloanById(Long id);
}
