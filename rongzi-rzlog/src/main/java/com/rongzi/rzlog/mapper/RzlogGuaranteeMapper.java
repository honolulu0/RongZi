package com.rongzi.rzlog.mapper;

import java.util.List;

import com.rongzi.rzlog.domain.LogGuaranteeSummary;
import com.rongzi.rzlog.domain.RzlogGuarantee;

/**
 * 历史担保Mapper接口
 * 
 * @author rongzi
 * @date 2024-03-24
 */
public interface RzlogGuaranteeMapper 
{
    /**
     * 查询历史担保
     * 
     * @param id 历史担保主键
     * @return 历史担保
     */
    public RzlogGuarantee selectRzlogGuaranteeById(Long id);

    /**
     * 查询历史担保列表
     * 
     * @param rzlogGuarantee 历史担保
     * @return 历史担保集合
     */
    public List<RzlogGuarantee> selectRzlogGuaranteeList(RzlogGuarantee rzlogGuarantee);

    /**
     * 查询历史担保列表
     *
     * @param rzlogGuarantee 历史担保
     * @return 历史担保集合
     */
    public List<LogGuaranteeSummary> selectGuaranteeSummary(RzlogGuarantee rzlogGuarantee);

    /**
     * 新增历史担保
     * 
     * @param rzlogGuarantee 历史担保
     * @return 结果
     */
    public int insertRzlogGuarantee(RzlogGuarantee rzlogGuarantee);

    /**
     * 修改历史担保
     * 
     * @param rzlogGuarantee 历史担保
     * @return 结果
     */
    public int updateRzlogGuarantee(RzlogGuarantee rzlogGuarantee);

    /**
     * 删除历史担保
     * 
     * @param id 历史担保主键
     * @return 结果
     */
    public int deleteRzlogGuaranteeById(Long id);

    /**
     * 批量删除历史担保
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRzlogGuaranteeByIds(Long[] ids);
}
