package com.rongzi.rzafterloan.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.rongzi.rzafterloan.domain.rzafterloan;
import com.rongzi.appendix.domain.rzsrc2;

/**
 * 贷后管理Mapper接口
 *
 * @author rongzi
 * @date 2024-03-20
 */
public interface rzafterloanMapper {
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

    public Map<String, BigDecimal> selectRzAfterLoanSum(rzafterloan rzafterloan);

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
     * 删除贷后管理
     *
     * @param id 贷后管理主键
     * @return 结果
     */
    public int deleterzafterloanById(Long id);

    /**
     * 批量删除贷后管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleterzafterloanByIds(Long[] ids);

    /**
     * 批量删除附件表
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleterzsrc2ByScrUuids(Long[] ids);

    /**
     * 批量新增附件表
     *
     * @param rzsrc2List 附件表列表
     * @return 结果
     */
    public int batchrzsrc2(List<rzsrc2> rzsrc2List);


    /**
     * 通过贷后管理主键删除附件表信息
     *
     * @param id 贷后管理ID
     * @return 结果
     */
    public int deleterzsrc2ByScrUuid(String id);
}
