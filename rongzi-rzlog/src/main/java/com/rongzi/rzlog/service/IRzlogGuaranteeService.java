package com.rongzi.rzlog.service;

import java.util.List;

import com.rongzi.rzlog.domain.LogGuaranteeSummary;
import com.rongzi.rzlog.domain.RzlogGuarantee;

/**
 * 历史担保Service接口
 * 
 * @author rongzi
 * @date 2024-03-24
 */
public interface IRzlogGuaranteeService 
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
    public List<LogGuaranteeSummary> getGuaranteeSummary(RzlogGuarantee rzlogGuarantee);


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
     * 批量删除历史担保
     * 
     * @param ids 需要删除的历史担保主键集合
     * @return 结果
     */
    public int deleteRzlogGuaranteeByIds(Long[] ids);

    /**
     * 删除历史担保信息
     * 
     * @param id 历史担保主键
     * @return 结果
     */
    public int deleteRzlogGuaranteeById(Long id);
}
